package me.nickvo;

import java.util.Arrays;

public class MergeWorker implements Runnable {
    private final int[] array1;
    private final int[] array2;
    private int[] combined;

    public MergeWorker(int[] array1, int[] array2) {
        this.array1 = array1;
        this.array2 = array2;
    }

    public int[] getMergedArray() {
        return combined;
    }

    @Override
    public void run() {
        combined = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, combined, array1.length, array2.length);
    }
}
