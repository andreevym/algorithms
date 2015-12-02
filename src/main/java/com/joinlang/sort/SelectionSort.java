package com.joinlang.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<? extends T> sort(Collection<? extends T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("unsorted array cann't be null");
        }
        System.out.println("This is selection sort O(N*N)");
        System.out.println("array before soring: " + collection);


        /*
            берем левый не отсортированный элемент
            принимаем его за минимальный
            сравниваем со всеми эелементами в списке
            по достижению конца списка
            делаем перестановку минимального элемента и левого не отсортированного эелемента
         */

        List<? extends T> list = new ArrayList<>(collection);
        for (int i = 0; i < collection.size() - 1; i++) {
            int minimumIndex = i;
            for (int j = i; j < collection.size(); j++) {
                if (list.get(minimumIndex).compareTo(list.get(j)) > 0) {
                    minimumIndex = j;
                }
            }
            Collections.swap(list, minimumIndex, i);
        }

        System.out.println("array after sorting: " + list);
        return list;
    }
}
