package com.hqw.queue;

/**
 * @author hqw521@qq.com
 * @date 2018/6/5 11:02
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
