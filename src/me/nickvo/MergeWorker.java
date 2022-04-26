package me.nickvo;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

public class MergeWorker implements Runnable {
    private final BlockingQueue<int[]> q;

    public MergeWorker(BlockingQueue<int[]> q) {
        this.q = q;
    }

    @Override
    public void run() {
        int[] array1 = new int[20];
        int[] array2 = new int[20];

        try {
            array1 = q.take();
            array2 = q.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int[] combined = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, combined, array1.length, array2.length);

        System.out.println("Final array: " + Arrays.toString(combined));
    }
}
