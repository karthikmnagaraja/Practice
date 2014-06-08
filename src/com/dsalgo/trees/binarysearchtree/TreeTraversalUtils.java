package com.dsalgo.trees.binarysearchtree;

import java.util.*;

/**
 * @author Karthik Nagaraj
 * @param <T>
 */
public class TreeTraversalUtils<T extends Comparable<T>> {

    public void printVerticalSum(Node<Integer> node, HashMap<Integer,Integer> map,int column){
        if(node==null){
            return;
        }
        printVerticalSum(node.left,map,column-1);
        int count=0;
        if(map.containsKey(column)){
            count=map.get(column);
        }
        map.put(column,count+node.data);
        printVerticalSum(node.right, map, column + 1);
    }



    public void printLevelOrder(Node<T> root) {
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(root);

        int nodesInNextLevel = 0, nodesInCurrentLevel = 1;
        while (queue.size() > 0) {
            Node<T> node = queue.remove();
            nodesInCurrentLevel--;
            System.out.print(" " + node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
                nodesInNextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nodesInNextLevel++;
            }

            if (nodesInCurrentLevel == 0) {
                System.out.println();
                nodesInCurrentLevel = nodesInNextLevel;
                nodesInNextLevel = 0;
            }
        }
    }

    public void bfs(Node<T> root) {
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(root);

        while (queue.size() > 0) {
            Node<T> node = queue.poll();
            System.out.print(" " + node.data + " ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

        }

    }

    public void zigZagTraversal(Node<T> root) {
        Node<T> currentNode = root;
        Stack<Node<T>> currentLevel = new Stack<Node<T>>();
        Stack<Node<T>> nextLevel = new Stack<Node<T>>();

        boolean isLeftToRight = false;
        currentLevel.add(currentNode);
        while (!currentLevel.isEmpty()) {
            Node<T> node = currentLevel.pop();

            if (node != null || node.data != null) {
                System.out.print(node.data + " ");
                if (isLeftToRight) {
                    if (node.left != null) {

                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                }


            }
            if(currentLevel.isEmpty()){
                System.out.println();
                isLeftToRight=!isLeftToRight;
                Stack<Node<T>> temp=currentLevel;
                currentLevel=nextLevel;
                nextLevel=temp;
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BST<String> tree = new BST<String>();
        tree.insert("i am lazy");
        TreeTraversalUtils<String> utilstr = new TreeTraversalUtils<String>();


        TreeTraversalUtils<Integer> utils = new TreeTraversalUtils<Integer>();


        Integer[] a = {5, 3, 2, 7, 4, 6, 8};
        BST<Integer> bst = new BST<Integer>();
        for (Integer n : a)
            bst.insert(n);
        utils.printLevelOrder(bst.getRoot());

        //utils.bfs(bst.getRoot());
        //utils.zigZagTraversal(bst.getRoot());
        HashMap<Integer,Integer>countMap=new HashMap<Integer, Integer>();
        utils.printVerticalSum(bst.getRoot(),countMap,0);
        for(Map.Entry<Integer,Integer> entry:countMap.entrySet()){
            System.out.println(entry.getKey()+"------>"+entry.getValue());
        }
    }

}
