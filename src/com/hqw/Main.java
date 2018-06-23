package com.hqw;

import java.util.Random;

import com.hqw.sort.Test;
import com.hqw.stack.TestStack;
import com.hqw.tree.BST;
import com.hqw.tree.BSTNR;

public class Main {

    // 打乱数组顺序
    private static void shuffle(Object[] arr){

        for(int i = arr.length - 1 ; i >= 0 ; i --){
            int pos = (int) (Math.random() * (i + 1));
            Object t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
    }

    public static void main(String[] args) {
        Test.testSelectionSort();
        System.out.println("sort test");
        Test.testInsertionSort();
    }
}
