package com.dsalgo.linkedlist;

import java.util.NoSuchElementException;

/**
 * @author KarthikMNagaraja.
 */
public class DoubleLinkedList<T extends Comparable<T>> {



    private Node<T> head, tail;



    public DoubleLinkedList(T item) {
        head = tail = new Node<T>(item);
    }
    public DoubleLinkedList(){}

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
    public void addLast(T item) {
        Node<T> oldTail=tail;
        tail = new Node<T>(item, tail, oldTail);

        if (head == null) {
            head = tail;
        }else
            oldTail.next=tail;

    }

    public void addFirst(T item) {
        Node<T> oldHead=head;
        head = new Node<T>(item, head, oldHead);

        if (tail == null)
            tail = head;
        else
            oldHead.prev=head;
    }


    public T removeLast(){
        if(tail==null){
            throw new NoSuchElementException("DLL is empty");
        }
        T item= tail.data;
        tail=tail.prev;
        if(tail!=null)
            tail.next=null;
        return item;
    }

    public T removeFirst(){
        if(head==null){
            throw new NoSuchElementException("DLL is empty");
        }
        T item=head.data;
        head=head.next;
        if(head!=null)
            head.prev=null;
        return item;
    }


    private static class Node<T extends Comparable<T>> {

        private T data;
        private Node<T> next, prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev=null;
        }

        public Node(T data, Node<T> next, Node<T> prev) {
            this.next = next;
            this.data = data;
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public int compare(final T other) {
            return this.data.compareTo(other);
        }

    }


    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList=new DoubleLinkedList<Integer>();
        doubleLinkedList.addFirst(20);
        doubleLinkedList.addLast(30);
        doubleLinkedList.addFirst(10);
        doubleLinkedList.addLast(40);

        System.out.println(doubleLinkedList.removeFirst());

        System.out.println(doubleLinkedList.removeFirst());
        System.out.println(doubleLinkedList.removeLast());
        System.out.println(doubleLinkedList.removeLast());
        System.out.println(doubleLinkedList.removeLast());

    }

}
