package com.joinlang.utils;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static List<Integer> makeIntegerArray(int count) {
        List<Integer> list = IntStream.range(0, count).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        return list;
    }

    private static int[] shuffle(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
            array = swap(array, i, random.nextInt(array.length - 1));
        return array;
    }

    public static int[] makeIncrementArray(int count) {
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = i;
        }
        return array;
    }
}
