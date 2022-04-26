package me.nickvo;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int[] original = getRandomArray(20);

        int[] copy1 = Arrays.copyOfRange(original, 0, original.length / 2);
        int[] copy2 = Arrays.copyOfRange(original, original.length / 2, original.length);

        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("First half: " + Arrays.toString(copy1));
        System.out.println("Second half: " + Arrays.toString(copy2));

        BlockingQueue<int[]> q = new LinkedBlockingQueue<>();

        SortWorker sortWorker = new SortWorker(copy1, q);
        Thread sortThread1 = new Thread(sortWorker);
        sortThread1.start();
        sortThread1.join();

        SortWorker sortWorker2 = new SortWorker(copy2, q);
        Thread sortThread2 = new Thread(sortWorker2);
        sortThread2.start();
        sortThread2.join();

        MergeWorker mergeWorker = new MergeWorker(q);
        Thread mergeThread = new Thread(mergeWorker);
        mergeThread.start();
        mergeThread.join();
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
