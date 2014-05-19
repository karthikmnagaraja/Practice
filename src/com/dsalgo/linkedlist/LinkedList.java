package com.dsalgo.linkedlist;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Collection;

/**
 * @author KarthikMNagaraja.
 */
public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    public LinkedList() {
        head = null;
    }

    public LinkedList(Collection<T> list){
        this();
        for(T element:list){
            this.addFirst(element);
        }
        this.reverse();
    }

    public void SortedLinkedList(Collection<T> list){

        for(T element:list){
            this.insertToSortedList(element);
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T data) {
        head = new Node(data, head);
    }

    public void addLast(T data) {
        if (head == null) {
            head = new Node(data, head);
        } else {
            Node<T> temp = head;
            while (temp != null) {
                temp = temp.next;
            }
            temp.next = new Node(data, null);
        }
    }

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public T getLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public T removeFirst() {
        T temp = this.getFirst();
        head = head.next;
        return temp;
    }

    public T removeLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }
        T result = temp.next.data;
        temp.next = null;
        return result;
    }

    public void remove(T data) {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        Node<T> cur = head;
        Node<T> prev = null;

        while (cur != null && !cur.data.equals(data)) {
            prev = cur;
            cur = cur.next;
        }
        if(cur==null){
            throw new NoSuchElementException();
        }
        prev.next=cur.next;
    }

    public LinkedList<T> reverse(){
        LinkedList<T> list= new LinkedList<T>();
        Node<T> temp= head;
        while(temp!=null) {
            list.addFirst(temp.data);
            temp=temp.next;
        }
        return list;
    }

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


    public void insertToSortedList(T data){
        Node<T> currentNode=head;
        if(head==null||head.data.equals(data)){
            head=new Node(data,head);
            return;
        }
        while(currentNode.next!=null&&currentNode.compare(data)>0){
            currentNode=currentNode.next;
        }
        currentNode.next=new Node(data,currentNode.next);
    }


    public void removeDuplicate(Node<T> head){
        if(head==null){
            return;
        }

        Node<T> currentNode=head;

        while(currentNode.next!=null){
            if(currentNode.data.compareTo(currentNode.next.data)==0){
                currentNode.next=currentNode.next.next;
            }
            else{
                currentNode= currentNode.next;
            }
        }
    }

    public Iterator<T> iterator(){
       return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{

        private Node<T> nextNode;

        private LinkedListIterator() {
            this.nextNode = head;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        public boolean hasNext(){
            return nextNode.next!=null;
        }

        public T next(){
            if(nextNode.next==null) throw new NoSuchElementException();
            T result=nextNode.data;
            nextNode=nextNode.next;
            return result;
        }

    }
    public void print(){
        Iterator<T> iterator= this.iterator();
        while(iterator.hasNext()){

            System.out.print(iterator.next().toString()+"->");
        }
        System.out.println("null");
    }
}
