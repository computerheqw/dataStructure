package com.hqw.sort;

/**
 * @author hqw521@qq.com
 * @date 2018/6/20 9:45
 */
public class Test {
    public static void testSelectionSort() {
        Integer[] array = SortTestHelper.generateRandomArray(10, 50, 100);
        SortTestHelper.printArray(array);
        new Sort<Integer>().selectionSort(array);
        SortTestHelper.printArray(array);
    }

    public static void testInsertionSort() {
        Integer[] array = SortTestHelper.generateRandomArray(10, 50, 100);
        SortTestHelper.printArray(array);
        new Sort<Integer>().insertionSort(array);
        SortTestHelper.printArray(array);
    }
}
