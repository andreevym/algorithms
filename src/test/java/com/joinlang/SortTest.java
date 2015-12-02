package com.joinlang;

import com.joinlang.sort.Sort;
import com.joinlang.utils.ArrayUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public abstract class SortTest<V extends Comparable<V>, T extends Sort<V>> {

    public static final int ARRAY_LENGTH = 10;
    private List<? extends V> correctArray;

    private Collection<? extends V> testArray;
    private T instanse;

    public SortTest() {
        try {
            instanse = getTypeParameterClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public Class<T> getTypeParameterClass() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        return (Class<T>) paramType.getActualTypeArguments()[0];
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("@org.testng.annotations.BeforeMethod");
        // testArray = ArrayUtils.makeArray(ARRAY_LENGTH);
        // correctArray = ArrayUtils.makeIncrementArray(ARRAY_LENGTH);
    }

    @Test(invocationCount = 120)
    public void testSort() throws Exception {
        System.out.println("@org.testng.annotations.Test");

        List<? extends V> result = instanse.sort(getTestArray());

        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), ARRAY_LENGTH);
        Assert.assertEquals(result, getCorrectArray());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("@org.testng.annotations.AfterMethod");
        testArray = null;
    }

    public List<? extends V> getCorrectArray() {
        return correctArray;
    }

    public void setCorrectArray(List<? extends V> correctArray) {
        this.correctArray = correctArray;
    }

    public Collection<? extends V> getTestArray() {
        return testArray;
    }

    public void setTestArray(Collection<? extends V>  testArray) {
        this.testArray = testArray;
    }

    public T getInstanse() {
        return instanse;
    }
}
