package com.joinlang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainAOP implements SortExecutor {

    public static final int array_length = 100;

    public static void main(String[] args) {
        // WithOUT Proxy
        AuditProxy.apply(null, e -> new MainAOP().execute());

        // With Proxy
        SortExecutor main = (SortExecutor) AuditProxy.newInstance(new MainAOP());
        main.execute();

        //tryRemoveFromSubListExample();
    }

    private static void tryRemoveFromSubListExample() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(12);
        arrayList.add(11);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        arrayList.add(16);
        System.out.println("size array list: " + arrayList.size());
        List list = arrayList.subList(2, 5);
        list.remove(1);
        System.out.println("size sub array list: " + arrayList.size());
        arrayList.trimToSize();
    }

    public boolean execute() {
        int[] array = ArrayUtils.makeArray(array_length);
        SelectionSort.sort(array);
        return true;
    }


}