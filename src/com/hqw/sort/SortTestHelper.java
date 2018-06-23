package com.hqw.sort;

import java.util.Random;

/**
 * @author hqw521@qq.com
 * @date 2018/6/20 9:19
 */
public class SortTestHelper<E> {
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        if (rangeL >= rangeR) {
            throw new IllegalArgumentException("rangeL >= rangeR");
        }
        Random random = new Random();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return array;
    }

    public static<E> void printArray(E[] data) {
         for (int i = 0; i < data.length; i++) {
             System.out.print(data[i] + " ");
         }
        System.out.println();
    }
}
