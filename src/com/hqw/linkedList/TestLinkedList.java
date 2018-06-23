package com.hqw.linkedList;

import com.hqw.linkedList.LinkedList;
/**
 * @author hqw521@qq.com
 * @date 2018/6/6 11:04
 */
public class TestLinkedList {

    public static void Test() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
