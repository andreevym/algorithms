package com.joinlang.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class InsertSort<T extends Comparable<T>> implements Sort<T> {

    private static void moveArray(int[] array, int startIndex, int endIndex) {
        for (int i = endIndex; i < 0; i--) {
            array[i] = array[i - 1];
        }
    }

    /**
     * На момент сортировки методом вставки массив должен быть на половину отсортирован
     */
    @Override
    public List<? extends T> sort(Collection<? extends T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("unsorted array can not be null");
        }
        System.out.println("This is bubble sort O(N*N)");
        System.out.println("array before soring: " + collection);



        List<T> list = new ArrayList<>(collection);

        int j;
        for (int i = 1; i < list.size(); i++) {
            T tmp = list.get(i);
            j = i;

            System.out.println("i = " + i);
            System.out.println("tmp = " + tmp);

            while (j > 0 && list.get(j - 1).compareTo(tmp) >= 0) {
                list.set(j, list.get(j - 1));
                --j;
            }
            list.set(j, tmp);
        }

        System.out.println("array after sorting: " + list);
        return list;
    }
}