package me.nickvo;

import java.util.Arrays;

public class SortWorker implements Runnable {
    private final int[] array;

    public SortWorker(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }

        System.out.println("Sorted array: " + Arrays.toString(array));
        
    }
}
