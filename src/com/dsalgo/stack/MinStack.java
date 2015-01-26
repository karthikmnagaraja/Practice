package com.dsalgo.stack;

public class MinStack {
    private static java.util.Stack<Integer> aux= new java.util.Stack<Integer>();
    private static java.util.Stack<Integer> min= new java.util.Stack<Integer>();
    public void push(int x) {
        if(min.isEmpty()||x<=min.peek())
            min.push(x);
        aux.push(x);
    }

    public void pop() {
        if(min.peek()==aux.peek())
            min.pop();
         aux.pop();

    }

    public int top() {
       return  aux.peek();
    }

    public int getMin() {
        if(min.isEmpty())return Integer.MIN_VALUE;

        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack= new MinStack();
        minStack.push(-1);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }


}