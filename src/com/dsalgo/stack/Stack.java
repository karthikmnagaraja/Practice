package com.dsalgo.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author KarthikMNagaraja.
 */
public class Stack<T>  implements Iterable<T>{
    private Node first;
    private int count;
    private static class Node<T>{
        T item;
        Node next;
        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }

    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return count;
    }

    public void push(T item){
        first= new Node(item,first);
        count++;
    }

    public Object pop(){
        if(first!=null){
            Object popItem= first.item;
            first=first.next;
            return popItem;
        }
        throw new NoSuchElementException("Stack is empty");


    }
    public Object peek(){
        if(first==null) throw new NoSuchElementException("Stack is empty");

        return first.item;
    }

    public Iterator iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T>{
        private Node currentNode= first;
        public void remove(){}
        public T next(){
            T item=(T)currentNode.item;
            currentNode=currentNode.next;
            return item;
        }
        public boolean hasNext(){
            return currentNode!=null;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> integerStack= new Stack<Integer>();
        System.out.println(integerStack.isEmpty());

        integerStack.push(10);
        integerStack.push(20);
        System.out.println(integerStack.peek());
        integerStack.push(30);
        integerStack.push(40);
        System.out.println(integerStack.count);
        System.out.println(integerStack.pop());
        System.out.println(integerStack.pop());
        System.out.println(integerStack.pop());
        System.out.println(integerStack.pop());
        System.out.println(integerStack.pop());

    }

}
