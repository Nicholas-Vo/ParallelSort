package me.nickvo;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] original = getRandomArray(20);

        int[] copy1 = Arrays.copyOfRange(original, 0, original.length / 2);
        int[] copy2 = Arrays.copyOfRange(original, original.length / 2, original.length);

        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("First half: " + Arrays.toString(copy1));
        System.out.println("Second half: " + Arrays.toString(copy2));

        SortWorker sortWorker = new SortWorker();
        Thread sortThread = new Thread(sortWorker);

        sortWorker.setArray(copy1);
        sortThread.start();

        int[] sortedArray1 = sortWorker.getSortedArray();

        Thread sortThread2 = new Thread(sortWorker);
        sortWorker.setArray(copy2);
        sortThread2.start();

        int[] sortedArray2 = sortWorker.getSortedArray();

        System.out.println("Sorted array 1: " + Arrays.toString(sortedArray1));
        System.out.println("Sorted array 2: " + Arrays.toString(sortedArray2));

        MergeWorker mergeWorker = new MergeWorker(sortedArray1, sortedArray2);
        Thread mergeThread = new Thread(mergeWorker);
        mergeThread.start();

        int[] combined = mergeWorker.getMergedArray();
        System.out.println("Final array: " + Arrays.toString(combined));
    }

    private static int[] getRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(250);
        }
        return array;
    }
}
