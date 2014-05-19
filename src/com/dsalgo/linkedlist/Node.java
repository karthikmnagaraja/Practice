package com.dsalgo.linkedlist;

/**
 * @author KarthikMNagaraja.
 */
public class Node<T extends Comparable<T>>{
    public T data;
    public Node<T> next;

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
