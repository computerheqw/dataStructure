package com.hqw.linkedList;

/**
 * @author hqw521@qq.com
 * @date 2018/6/6 19:03
 */
public class LinkedList<E> {
    private class Node {
        public E value;
        public Node next;

        public Node(E value, Node node) {
            this.value = value;
            this.next = node;
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
    private Node dummyHead; // 虚拟节点
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed, index is illegal");
        }

        Node previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }
        previous.next = new Node(value, previous.next);
        size++;
    }

    public void addFirst(E value) {
        add(0, value);
    }

    public void addLast(E value) {
        add(size, value);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed, index is illegal");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed, index is illegal");
        }
        Node previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }
        Node temp = previous.next;
        previous.next = temp.next;
        temp.next = null;
        size--;
        return temp.value;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed, index is illegal");
        }
        Node current = dummyHead;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = value;
    }

    public boolean contains(E value) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node current = dummyHead.next;
        while (current != null) {
            res.append(current.value + " -> ");
            current = current.next;
        }
        res.append("NULL");
        return res.toString();
    }

}
