package com.joinlang;

import com.joinlang.proxy.AuditProxy;
import com.joinlang.proxy.SortExecutor;
import com.joinlang.sort.BubbleSort;
import com.joinlang.sort.Sort;
import com.joinlang.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class MainAOP implements SortExecutor {

    private static final int ARRAY_LENGTH = 4;

    public static void main(String[] args) {
        // WithOUT Proxy
        //AuditProxy.apply(null, e -> new MainAOP().execute());

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

    public void execute() {
        List<Integer> array = ArrayUtils.makeIntegerArray(ARRAY_LENGTH);
        Sort<Integer> triage = new BubbleSort<>();
        triage.sort(array);
    }
}