package me.nickvo;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

/**
 * Nick Voss
 * IT386 01
 * Homework 5
 */
public class MergeWorker implements Runnable {
    private final BlockingQueue<int[]> q;

    public MergeWorker(BlockingQueue<int[]> q) {
        this.q = q;
    }

    @Override
    public void run() {
        int[] array1 = null;
        int[] array2 = null;

        // Attempt to obtain array from sorter thread
        try {
            array1 = q.take();
            array2 = q.take();
        } catch (InterruptedException e) {
            System.out.println("Error: One or more of the arrays is null.");
        }

        int[] combined = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, combined, array1.length, array2.length);

        System.out.println();
        Printer.print("Final array: ", combined);
    }
}
