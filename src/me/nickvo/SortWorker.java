package me.nickvo;

import java.util.concurrent.BlockingQueue;
/**
 * Nick Voss
 * IT386 01
 * Homework 5
 */
public class SortWorker implements Runnable {
    private final int[] array;
    private final BlockingQueue<int[]> q;

    public SortWorker(int[] array, BlockingQueue<int[]> q) {
        this.array = array;
        this.q = q;
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

        Printer.print("Sorted array: ", array);
        try {
            q.put(array); // Give array to merge thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
