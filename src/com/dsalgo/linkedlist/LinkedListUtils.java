package com.dsalgo.linkedlist;

import java.util.Iterator;

/**
 * @author KarthikMNagaraja.
 */
public class LinkedListUtils {



    public static void main(String[] args) {

        LinkedList<Integer> intList = new LinkedList<Integer>();
        /*
        int[] list = {10, 12, 9, 8, 5, 20, 9, 12};
        for (int i = 0; i < list.length; i++) {
            intList.insertToSortedList(list[i]);
        }

        intList.print();

        intList.removeDuplicate(intList.getHead());
        intList.print();*/



    }

    public static void reverse(LinkedList.Node node){
        LinkedList.Node prev = null;
        LinkedList.Node currentNode = node;
        LinkedList.Node nextNode = null;

        while(currentNode!=null){
            nextNode=currentNode.getNext();
            
        }



    }

    public boolean isPalindrome(LinkedList linkedList) {
        LinkedList.Node slowPtr = linkedList.getHead();
        Iterator fastPtr = linkedList.fastIterator();

        while (slowPtr!=null &&slowPtr.getNext()!=null && fastPtr.hasNext()) {
            slowPtr=slowPtr.getNext();
            fastPtr.next();
        }




        return true;


    }
}
