package com.hqw.stack;

/**
 * @author hqw521@qq.com
 * @date 2018/6/5 10:25
 */
public interface Stack<E> {
    void push(E value);
    E pop();
    E peek();
    int getSize();
    boolean isEmpty();
}
