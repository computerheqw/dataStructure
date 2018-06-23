package com.hqw.tree;

/**
 * @author hqw521@qq.com
 * @date 2018/6/8 17:05
 */
public class Test {
    public static void test() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
    }
}
