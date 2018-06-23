package com.hqw.queue;

import com.hqw.array.Array;

/**
 * @author hqw521@qq.com
 * @date 2018/6/5 11:03
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
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
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 查看队首元素
     * @return
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front[");
        for (int i = 0; i < getSize(); i++) {
            res.append(array.get(i));
            if (i != getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("]tail");
        return res.toString();
    }
}
