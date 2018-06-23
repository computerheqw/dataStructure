package com.hqw.sort;

/**
 * @author hqw521@qq.com
 * @date 2018/6/19 19:48
 */
public class Sort<E extends Comparable<E>> {
    // 选择排序
    public void selectionSort(E[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = minIndex + 1; j < data.length; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
                if (minIndex != i) {
                    E temp = data[minIndex];
                    data[minIndex] = data[i];
                    data[i] = temp;
                }
            }
        }
    }

    // 插入排序
    public void insertionSort(E[] data) {
        for (int i = 1; i < data.length; i++) {
            E temp = data[i];
            int j;
            for ( j = i; j > 0 && (data[j - 1].compareTo(temp) > 0); j--) {
              data[j] = data[j - 1];
            }
            data[j] = temp;
        }
    }
}
