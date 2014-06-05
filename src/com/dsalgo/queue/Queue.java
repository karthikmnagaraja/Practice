package com.dsalgo.queue;

import java.util.NoSuchElementException;

/**
 * @author KarthikMNagaraja.
 */
public class Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    public int size;
    private class Node<T>{
        T item;
        Node next;
        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }

    public boolean isEmpty(){
        return (head==null &&tail==null);
    }


    public int size(){
        return size;
    }
    public void add(T item){
        Node<T> oldTail=tail;
        tail = new Node(item,null);

        if(head==null)
            head=tail;
        else{
            oldTail.next=tail;
        }
        size++;
    }
    public T remove(){
        if(head==null)
            throw new NoSuchElementException("Queue is empty");

        T item= head.item;
        head=head.next;
        --size;
        return item;
    }

    public T peek(){
        if(head==null) throw new NoSuchElementException("Queue is empty");
        return head.item;

    }

    public static void main(String[] args) {
        Queue<Integer> queue= new Queue<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(23);
        queue.add(2);
        System.out.println(queue.peek());
       System.out.println(queue.size());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.size());

          System.out.println(queue.remove());

    }

}
