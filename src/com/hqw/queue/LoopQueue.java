package com.hqw.queue;

/**
 * @author hqw521@qq.com
 * @date 2018/6/5 19:45
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;

    public LoopQueue(int capactiy) {
        data = (E[]) new Object[capactiy + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 获取队列大小
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 获取队列长度
     * @return
     */
    @Override
    public int getSize() {
        return (tail - front + data.length) % data.length;
    }

    /**
     * 查看队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 入队
     * @param value
     */
    @Override
    public void enqueue(E value) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = value;
        tail = (tail + 1) % data.length;
    }

    /**
     * 出队列
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty, dequeue failed");
        }
        E temp = data[front];
        front = (front + 1) % data.length;
        if (getSize() <= getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return  temp;
    }

    /**
     * 获取队首元素
     * @return
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Queue: size = %d, capactiy = %d\n", getSize(), getCapacity()));
        stringBuilder.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            stringBuilder.append(data[i]);
            if ((i + 1) % data.length != tail) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]tail");
        return stringBuilder.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(front + i) % data.length];
        }
        tail = getSize();
        data = newData;
        front = 0;
    }
}
