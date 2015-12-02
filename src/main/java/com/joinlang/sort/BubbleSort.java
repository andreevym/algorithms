package com.joinlang.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<? extends T> sort(Collection<? extends T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("unsorted array can't be null");
        }
        System.out.println("This is bubble sort O(N*N)");
        System.out.println("array before soring: " + collection);

        List<? extends T> list = new ArrayList<>(collection);
        for (int i = list.size() - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        System.out.println("array after sorting: " + list);
        return list;
    }
}
