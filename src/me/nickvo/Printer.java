package me.nickvo;

import java.util.Arrays;

public class Printer {

    public static void print(String msg, int[] array) {
        if (array.length < 50) {
            System.out.println(msg + " " + Arrays.toString(array));
        }
    }

}
