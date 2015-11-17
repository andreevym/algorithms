package com.joinlang;

public class BubbleSort {



    private static Integer[] array;

    public static void sort(Integer[] inArray) {
        if(inArray == null) {
            throw new IllegalArgumentException("unsorted array cann't be null");
        }
        array = inArray;

        for (int passWholeArray = array.length - 1; passWholeArray > 1 ; passWholeArray--) {
            for (int mark = 0; mark < passWholeArray; mark++) {
                if (array[mark] > array[mark + 1]) {
                    swap(mark, mark + 1);
                }
            }
        }
    }

    private static void swap(Integer currentElement, Integer nextElement) {
        Integer temp = array[currentElement];
        array[currentElement] = array[nextElement];
        array[nextElement] = temp;
    }
}
