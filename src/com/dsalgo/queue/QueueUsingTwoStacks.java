package com.dsalgo.queue;

import com.dsalgo.stack.Stack;

/**
 * @author KarthikMNagaraja.
 */
public class QueueUsingTwoStacks<T> {
    private Stack<T> inbox,outbox;
    public QueueUsingTwoStacks(){
        inbox= new Stack<T>();
        outbox= new Stack<T>();
    }

    public void enqueue(T item){
        inbox.push(item);
    }

    public T dequeue(){
        if(outbox.isEmpty()){
            while (!inbox.isEmpty()){
                outbox.push((T)inbox.pop());
            }
        }
        return (T)outbox.pop();
    }


}
