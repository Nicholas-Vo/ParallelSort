package me.nickvo;

public class SortWorker implements Runnable {
    private int[] array;

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getSortedArray() {
        return array;
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
    }
}
