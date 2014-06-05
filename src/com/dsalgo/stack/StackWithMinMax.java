package com.dsalgo.stack;

/**
 * Stack with min and max operations with complexity O(1)
 * @author KarthikMNagaraja.
 */
public class StackWithMinMax extends Stack<Integer> {

    private Stack<Integer> maxElements;
    private Stack<Integer> minElements;

    public StackWithMinMax(){
        minElements= new Stack<Integer>();
        maxElements=new Stack<Integer>();
    }
    public void push(int num){
        if(minElements.isEmpty() ||getMin()>=num){
            minElements.push(num);
        }
        if(maxElements.isEmpty()||getMax()<=num){
            maxElements.push(num);
        }
        super.push(num);
    }
    public Object pop(){
        int item=(Integer) super.pop();

        if(item==minElements.peek()){
            minElements.pop();
        }
        if(item==maxElements.peek()){
            maxElements.pop();
        }
        return item;

    }
    public int getMin(){
        if(minElements.isEmpty()) return Integer.MIN_VALUE;
        return (Integer)minElements.peek();
    }
    public int getMax(){
        if(maxElements.isEmpty()) return Integer.MAX_VALUE;
        return  (Integer)maxElements.peek();
    }

    public static void main(String[] args) {
       StackWithMinMax stackWithMinMax= new StackWithMinMax();
        stackWithMinMax.push(10);
        stackWithMinMax.push(-15);
        stackWithMinMax.push(2);
        stackWithMinMax.push(20);
        System.out.println("max-->"+stackWithMinMax.getMax()+"min-->"+stackWithMinMax.getMin());
    }
}
