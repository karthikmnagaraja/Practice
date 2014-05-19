package com.dsalgo.linkedlist;

/**
 * @author KarthikMNagaraja.
 */
public class LinkedListSortUtils<T extends Comparable<T>> {



    private static class Node<T extends Comparable<T>>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data=data;
            this.next=null;
        }

        public Node(T data,Node<T> next){
            this.next=next;
            this.data=data;
        }

        public int compare(final T other){
            return this.data.compareTo(other);
        }

    }




    public static void main(String[] args){
        LinkedList<Integer> intList= new LinkedList<Integer>();

        int[] list={10,12,9,8,5,20,9,12};
        for (int i = 0; i < list.length; i++) {
            intList.insertToSortedList(list[i]);
        }

        intList.print();

        intList.removeDuplicate(intList.getHead());
        intList.print();
    }
}
