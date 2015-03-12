package com.dsalgo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KarthikMNagaraja.
 * https://leetcode.com/problems/insert-interval/
 */


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}


public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result= new ArrayList<Interval>();
        for(Interval i:intervals){
            if(i.end<newInterval.start) result.add(i);
            else if (i.start>newInterval.end){
                result.add(newInterval);
                newInterval=i;
            }
            else if((i.end>=newInterval.start)|| (i.start<=newInterval.end)){
                newInterval= new Interval(newInterval.start>i.start?i.start:newInterval.start,newInterval.end>i.end?newInterval.end:i.end);
            }
        }
        result.add(newInterval);
        return result;
    }
}
