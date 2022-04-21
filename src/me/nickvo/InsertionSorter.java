package me.nickvo;

import java.util.Arrays;

public class InsertionSorter implements Runnable {
    private final int[] array;

    public InsertionSorter(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    @Override
    public void run() {
        Arrays.sort(array);
    }
}
