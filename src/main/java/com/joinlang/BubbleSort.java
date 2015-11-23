package com.joinlang;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] array) {
        if(array == null) {
            throw new IllegalArgumentException("unsorted array cann't be null");
        }
        System.out.println("This is bubble sort O(N*N)");
        System.out.println("array before soring: " + Arrays.toString(array));

        for (int passWholeArray = array.length - 1; passWholeArray > 1 ; passWholeArray--) {
            for (int mark = 0; mark < passWholeArray; mark++) {
                if (array[mark] > array[mark + 1]) {
                    ArrayUtils.swap(array, mark, mark + 1);
                }
            }
        }
    }
}
