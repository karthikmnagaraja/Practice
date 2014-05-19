package com.dsalgo.trees.binarysearchtree;

/**
 * @author Karthik Nagaraj
 * @param <T>
 */
class Node<T extends Comparable<T>> {
    public T data;
    public Node<T> left, right;

    public Node(T data) {
        this.left = this.right = null;
        this.data = data;
    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }

}
