package com.dsalgo.queue;

import com.dsalgo.stack.Stack;

import java.util.NoSuchElementException;

/**
 * @author KarthikMNagaraja.
 */
public class QueueUsingOneStack<T> {

    private Stack<T> stack;

    public QueueUsingOneStack(){
                stack= new Stack<T>();
            }

    public void add(T item){
        if(!stack.isEmpty()){
            T top= (T)stack.pop();
            add(item);
            stack.push(top);
        }else
            stack.push(item);

    }
    public T remove(){
        if(stack.isEmpty()) throw  new NoSuchElementException("Queue is empty!!");
        return (T) stack.pop();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public T peek(){
        return (T)stack.peek();
    }
    public static void main(String[] args) {
        QueueUsingOneStack<Integer> queue= new QueueUsingOneStack<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(23);
        queue.add(2);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println(queue.remove());
    }
}
