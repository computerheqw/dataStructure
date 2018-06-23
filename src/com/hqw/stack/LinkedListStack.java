package com.hqw.stack;

import com.hqw.linkedList.LinkedList;

/**
 * @author hqw521@qq.com
 * @date 2018/6/6 19:51
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;
    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E value) {
        list.addFirst(value);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top");
        res.append(list);
        return res.toString();
    }

}
