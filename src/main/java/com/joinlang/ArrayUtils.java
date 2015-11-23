package com.joinlang;

import java.util.Random;

public class ArrayUtils {

    public static int[] swap(int[] array, int fromIndex, int toRandomIndex) {
        int temp = array[toRandomIndex];
        array[toRandomIndex] = array[fromIndex];
        array[fromIndex] = temp;
        return array;
    }

    public static int[] makeArray(int count) {
        int[] array = makeIncrementArray(count);
        return shuffle(array);
    }

    private static int[] shuffle(int[] array) {
        Random random = new Random();
        for(int i = array.length - 1; i > 0; i--)
            array = swap(array, i, random.nextInt(array.length - 1));
        return array;
    }

    private static int[] makeIncrementArray(int count) {
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = i;
        }
        return array;
    }
}
