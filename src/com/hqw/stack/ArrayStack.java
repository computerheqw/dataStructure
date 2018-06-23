package com.hqw.stack;

import com.hqw.array.Array;

/**
 * @author hqw521@qq.com
 * @date 2018/6/5 10:26
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }
    public ArrayStack() {
        array = new Array<>();
    }

    /**
     * 获取队列容量
     * @return
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 获取栈中存储元素个数
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 查看是否为空栈
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 入栈
     * @param value
     */
    @Override
    public void push(E value) {
        array.addLast(value);
    }

    /**
     * 出栈
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶元素
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack: top: [");
        for (int i = getSize() - 1; i >= 0; i--) {
            res.append(array.get(i));
            if (i != 0) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
