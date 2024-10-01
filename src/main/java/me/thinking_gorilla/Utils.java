package me.thinking_gorilla;

import java.util.Arrays;

public class Utils {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void print(String description, int[] array) {
        System.out.println(description + " " + Arrays.toString(array));
    }
}
