package me.nickvo;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

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
            q.put(array);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
