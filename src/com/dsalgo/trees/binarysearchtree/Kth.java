package com.dsalgo.trees.binarysearchtree;

import com.dsalgo.stack.Stack;
import com.dsalgo.trees.binarysearchtree.*;
/**
 * @author KarthikMNagaraja.
 */
public class Kth<T extends Comparable<T>> {

    public static void main(String[] args) {
        Kth<Integer> kth = new Kth<Integer>();
        Integer[] a = {5, 3, 2, 7, 4, 6, 8};
        TreeTraversalUtils<Integer> utils = new TreeTraversalUtils<Integer>();

        BST<Integer> bst = new BST<Integer>();
        for (Integer n : a)
            bst.insert(n);
        utils.printLevelOrder(bst.getRoot());
        int num = 0, k = 3;

        System.out.println("kth smallest " + kth.kthSmallestUsingInorderTraversal(bst.getRoot(), 3));

        System.out.println("kth smallest " + kth.kthSmallestUsingInorderTraversal(bst.getRoot(), 10));
    }


    public T kthSmallestUsingInorderTraversal(Node<T> root, int k) {
        Stack<Node<T>> stack = new Stack<Node<T>>();
        Node<T> currentNode = root;
        boolean done = true;
        int num = 0;
        while (done) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (!stack.isEmpty()) {
                    currentNode = (Node) stack.pop();

                    num++;
                    if (num == k) {
                        done = false;
                        return currentNode.data;
                    }
                    currentNode = currentNode.right;
                } else
                    done = false;


            }

        }
        return null;
    }

}
