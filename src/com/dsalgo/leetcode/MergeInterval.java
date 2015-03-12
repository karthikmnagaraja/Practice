package com.dsalgo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by knagaraj on 3/12/2015.
 */
 class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "["+this.start+","+this.end+"]";
    }
}
public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<2){
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start,b.start);


            }
        });


        List<Interval> result= new ArrayList<Interval>(0);

        Interval temp= intervals.get(0);
        for (int i = 1; i <intervals.size() ; i++) {
            Interval in=intervals.get(i);
            if(temp.end<in.start){
                result.add(temp);
                temp=in;
            }else {
                temp.end=Math.max(in.end,temp.end);
            }
        }
        result.add(temp);
        return result;

    }

    public static void main(String[] args) {
        List<Interval> intervals= new ArrayList<Interval>();intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(12,16));
        MergeInterval m= new MergeInterval();

        System.out.println(m.merge(intervals).toString());
        intervals.add(new Interval(2,16));
        System.out.println(m.merge(intervals).toString());

    }
}

