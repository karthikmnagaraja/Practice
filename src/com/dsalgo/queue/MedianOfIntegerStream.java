package com.dsalgo.queue;

import java.util.PriorityQueue;

/**
 * Created by knagaraj on 12/15/2014.
 */
public class MedianOfIntegerStream {

    private PriorityQueue<Integer> minheap;
    private PriorityQueue<Integer> maxheap;
    public int numOfElements;

    public MedianOfIntegerStream() {
        minheap= new PriorityQueue<Integer>();
        maxheap= new PriorityQueue<Integer>();
        numOfElements =0;
    }



    public void insert(int num){
        maxheap.add(num*-1);
        if(numOfElements %2==0){
            if(minheap.isEmpty()){
                numOfElements++;
                return;
            }
            else if(minheap.peek()<maxheap.peek()*-1){
                int max=-1*maxheap.poll();
                int min= minheap.poll();
                maxheap.add(min*-1);
                minheap.add(max);
            }
        }else {
            minheap.add(maxheap.poll()*-1);
        }
        numOfElements++;
    }

    public double getMedian(){
        return numOfElements %2==0? (minheap.peek()+(maxheap.peek()*-1))/2.0:maxheap.peek()*-1;
    }

    public static void main(String[] args) {
        MedianOfIntegerStream streamMedian = new MedianOfIntegerStream();

        streamMedian.insert(1);
        System.out.println(streamMedian.getMedian()); // should be 1

        streamMedian.insert(5);
        streamMedian.insert(10);
        streamMedian.insert(12);
        streamMedian.insert(2);
        System.out.println(streamMedian.getMedian()); // should be 5

        streamMedian.insert(3);
        streamMedian.insert(8);
        streamMedian.insert(9);
        System.out.println(streamMedian.getMedian()); // should be 6.5
    }
}
