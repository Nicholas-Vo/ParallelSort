package me.nickvo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Nick Voss
 * IT386 01
 * Homework 5
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Enter array size:");
        Scanner scanner = new Scanner(System.in);

        int[] original = getRandomArray(scanner.nextInt());

        long startTime = System.currentTimeMillis();

        int[] copy1 = Arrays.copyOfRange(original, 0, original.length / 2);
        int[] copy2 = Arrays.copyOfRange(original, original.length / 2, original.length);

        Printer.print("Original: ", original);
        Printer.print("First half: ", copy1);
        Printer.print("Second half: ", copy2);
        System.out.println();
        Printer.print("First half: ", copy1);
        Printer.print("Second half: ", copy2);
        System.out.println();

        // BlockingQueue is used to pass between threads and maintain order
        BlockingQueue<int[]> q = new LinkedBlockingQueue<>();

        SortWorker sortWorker = new SortWorker(copy1, q);
        Thread sortThread1 = new Thread(sortWorker);
        sortThread1.start();
        sortThread1.join();

        SortWorker sortWorker2 = new SortWorker(copy2, q);
        Thread sortThread2 = new Thread(sortWorker2);
        sortThread2.start();
        sortThread2.join();

        MergeWorker mergeWorker = new MergeWorker(q);
        Thread mergeThread = new Thread(mergeWorker);
        mergeThread.start();
        mergeThread.join();

        System.out.println("Elapsed time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * Helper method to obtain a random array of integers
     *
     * @param length: The length
     * @return The array
     */
    private static int[] getRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(250);
        }
        return array;
    }
}
