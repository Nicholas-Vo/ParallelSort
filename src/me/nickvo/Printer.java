package me.nickvo;

import java.util.Arrays;
/**
 * Nick Voss
 * IT386 01
 * Homework 5
 */
public class Printer {

    /**
     * Helper method to print out an array with a message
     */
    public static void print(String msg, int[] array) {
        if (array.length < 50) {
            System.out.println(msg + " " + Arrays.toString(array));
        }
    }

}
