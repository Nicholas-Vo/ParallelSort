package me.nickvo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] original = getRandomArray(20);

        int[] copy1 = Arrays.copyOfRange(original, 0, original.length / 2);
        int[] copy2 = Arrays.copyOfRange(original, original.length / 2, original.length);

        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("First half: " + Arrays.toString(copy1));
        System.out.println("Second half: " + Arrays.toString(copy2));

        InsertionSorter sorter = new InsertionSorter(original);

        sorter.run();
        int[] sortedArray = sorter.getArray();

        System.out.println(Arrays.toString(sortedArray));
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
