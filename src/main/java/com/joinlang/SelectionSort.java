package com.joinlang;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("unsorted array cann't be null");
        }
        System.out.println("This is selection sort O(N*N)");
        System.out.println("array before soring: " + Arrays.toString(array));


        /*
            берем левый не отсортированный элемент
            принимаем его за минимальный
            сравниваем со всеми эелементами в списке
            по достижению конца списка
            делаем перестановку минимального элемента и левого не отсортированного эелемента
         */

        for (int i = 0; i < array.length - 1; i++) {
            int minimumIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minimumIndex] > array[j]) {
                    minimumIndex = j;
                }
            }
            ArrayUtils.swap(array, minimumIndex, i);
        }

        System.out.println("array after sorting: " + Arrays.toString(array));
    }
}
