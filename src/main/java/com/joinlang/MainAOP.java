package com.joinlang;

import java.util.Arrays;

public class MainAOP implements SortExecutor {

    public static final int array_length = 10;

    public static void main(String[] args) {
        // WithOUT Proxy
        AuditProxy.apply(null, e -> new MainAOP().execute());

        // With Proxy
        SortExecutor main = (SortExecutor) AuditProxy.newInstance(new MainAOP());
        main.execute();
    }

    public boolean execute() {
        int[] array = ArrayUtils.makeArray(array_length);
        BubbleSort.sort(array);
        System.out.println("array after sorting: " + Arrays.toString(array));
        return true;
    }


}