package com.dsalgo.trees.binarysearchtree;


import com.dsalgo.trees.binarysearchtree.Node;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Karthik Nagaraj
 * @param <T>
 */
public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public Node<T> getRoot() {
        return this.root;
    }

    public BST() {
        root = null;
    }


    public void insert(T data) {
        root = toInsert(root, data);
    }

    private Node<T> toInsert(Node<T> p, T data) {
        if (p == null) {
            return new Node<T>(data);
        }
        if (data.compareTo(p.data) == 0) {
            return p;
        }
        if (data.compareTo(p.data) < 0) {
            p.right = toInsert(p.right, data);
        } else
            p.left = toInsert(p.left, data);
        return p;
    }

    public boolean search(T data) {
        return toSearch(root, data);
    }

    private boolean toSearch(Node<T> p, T data) {
        if (p == null) {
            return false;
        }
        if (data.compareTo(p.data) == 0) {
            return true;
        }
        if (data.compareTo(p.data) > 0) {
            return toSearch(p.right, data);
        } else
            return toSearch(p.left, data);

    }

    private Node<T> delete(T data) {
        return toDelete(root, data);
    }

    private Node<T> toDelete(Node<T> p, T data) {
        if (null == p) {
            throw new RuntimeException("Element not found!!");

        }
        if (data.compareTo(p.data) > 0) {
            return toDelete(p.left, data);
        } else if (data.compareTo(p.data) < 0) {
            return toDelete(p.right, data);
        } else {

            if (p.left == null)
                return p.right;
            else if (p.right == null)
                return p.left;
            else {
                p.data = retrieveRightMost(p.left);
                p.left = toDelete(p.left, data);
            }
        }
        return p;
    }

    private T retrieveRightMost(Node<T> p) {
        while (p.right != null) {
            p = p.right;
        }
        return (T) p.data;
    }

    public int height(Node<T> p) {

        if (null == p) {
            return -1;
        } else
            return 1 + Math.max(height(p.right), height(p.left));
    }


    public void serialize(Node<T> p, ObjectOutputStream out) throws IOException {
        if (p != null) {
            out.writeChars(" " + p.data);
            serialize(p.left, out);
            serialize(p.right, out);
        } else {
            out.writeChars("#");
        }

    }


    public Node<T> deSerialize(Scanner reader) {
        //String data=reader.
        return null;
    }


    public static void main(String args[]) {

        Integer[] a = {1, 5, 2, 7, 4};
        BST<Integer> bst = new BST<Integer>();
        for (Integer n : a)
            bst.insert(n);
        BST<Integer> tree = new BST<Integer>();
        tree.insert(10);
        tree.insert(9);
        tree.insert(8);
        tree.insert(11);
        // tree.printLevelOrder(tree.root);

        //bst.printLevelOrder(bst.root);

    }

}