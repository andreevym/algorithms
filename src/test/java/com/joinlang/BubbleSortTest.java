package com.joinlang;

import com.joinlang.sort.BubbleSort;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class BubbleSortTest extends SortTest<BubbleSort> {

    @Test(invocationCount = 1)
    public void testSort() throws Exception {
        System.out.println("@org.testng.annotations.Test");

        List<Integer> result = getInstanse().sort(Arrays.asList(9, 5, 2, 4, 1, 6, 3, 8, 7, 0));

        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), ARRAY_LENGTH);
        Assert.assertEquals(result, getCorrectArray());
    }
}