package me.nickvo;

import java.util.Arrays;

public class MergeWorker implements Runnable {
    private int[] array1;
    private int[] array2;
    private int[] combined;

    public void setArray1(int[] arr) {
        array1 = arr;
    }

    public void setArray2(int[] arr) {
        array2 = arr;
    }

    @Override
    public void run() {
        combined = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, combined, array1.length, array2.length);

        System.out.println("Final array: " + Arrays.toString(combined));
    }
}
