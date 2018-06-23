package com.hqw.queue;

/**
 * @author hqw521@qq.com
 * @date 2018/6/6 20:27
 */
public class LinkedListQueue<E> implements Queue<E>{
    private class Node {
        public E value;
        public Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(E value) {
            this(value, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E value) {
        if (tail == null) {
            tail = new Node(value);
            head = tail;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("dequeue failed,queue is empty");
        }
        Node temp = head;
        head = temp.next;
        temp.next = null;
        if (head == null) {
            tail = null;
        }
        size --;
        return temp.value;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return head.value;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front");
        Node current = head;
        while (current != null) {
            res.append(current.value + " -> ");
            current = current.next;
        }
        res.append("Null tail");
        return res.toString();
    }
}
