package com.hqw.tree;

import java.util.Stack;

/**
 * @author hqw521@qq.com
 * @date 2018/6/10 16:34
 */
public class BSTNR<E extends Comparable<E>> {
    private class Node {
        public E value;
        public Node left;
        public Node right;

        public Node(E value) {
            this.value = value;
            this.left = null;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    public BSTNR() {
        root = null;
        size = 0;
    }

    public boolean contains(E value) {
        return contains(root, value);
    }

    private boolean contains(Node node, E value) {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }
        while (node != null) {
            if (value.compareTo(node.value) < 0) {
                node = node.left;
            } else if (value.compareTo(node.value) > 0) {
                node = node.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(E value) {
        if (root == null) {
            root = new Node(value);
        } else {
            add(root, value);
        }

    }

    private void add(Node node, E value) {
        Node parent = node;
        while (node != null) {
            if (value.compareTo(node.value) < 0) {
                parent = node;
                node = node.left;
            } else if (value.compareTo(node.value) > 0) {
                parent = node;
                node = node.right;
            } else {
                return;
            }
        }
        if (value.compareTo(parent.value) < 0) {
            parent.left = new Node(value);
        }
        else if (value.compareTo(parent.value) > 0) {
            parent.right = new Node(value);
        }
    }

    public void preOrder() {
        System.out.println();
        preOrder(root);
    }

    private void preOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.value + ",");
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.value + " ");
                node = node.right;
            }
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        Stack<Node> valueStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int i = 1;
        while (node != null || !valueStack.isEmpty()) {
            while (node != null) {
                valueStack.push(node);
                numStack.push(0);
                node = node.left;
            }

            while (!valueStack.isEmpty() && numStack.peek() == i) {
                numStack.pop();
                System.out.print(valueStack.pop().value + ", ");
            }
            if (!valueStack.isEmpty()) {
                numStack.pop();
                numStack.push(1);
                node = valueStack.peek();
                node = node.right;
            }
        }
    }
}
