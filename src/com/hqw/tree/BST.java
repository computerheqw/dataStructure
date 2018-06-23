package com.hqw.tree;

import java.util.LinkedList;
import java.util.Queue;
/**
 * @author hqw521@qq.com
 * @date 2018/6/8 15:20
 */
public class BST<E extends Comparable<E>> {
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

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 递归操作
    public void add(E value) {
        root = insert(root, value);
    }

    private Node insert(Node node, E value) {
        if (node == null) {
            size++;
            return new Node(value);
        }
        if (node.value.compareTo(value) > 0) {
            node.left = insert(node.left, value);
        } else if (node.value.compareTo(value) < 0) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public boolean contains(E value) {
        return contains(root, value);
    }

    private boolean contains(Node node, E value) {
        if (node == null) {
            return false;
        }

        if (node.value.compareTo(value) == 0) {
            return true;
        } else if (node.value.compareTo(value) > 0) {
            return contains(node.left, value);
        } else {
            return contains(node.right, value);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void preOrderNR(Node node) {

    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + ", ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }


    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.value);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).value;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public E minimum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).value;
    }

    private Node minimum(Node node) {
       if (node.left == null) {
           return node;
       }
       return minimum(node.left);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public void remove(E value) {
        root = remove(root, value);
    }

    private Node remove(Node node, E value) {
        if (node == null) {
            return null;
        }
        if (value.compareTo(node.value) < 0) {
            node.left = remove(node.left, value);
            return node;
        } else if (value.compareTo(node.value) > 0) {
            node.right = remove(node.right, value);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = new Node(minimum(node.right).value);

            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;
        }
    }

}
