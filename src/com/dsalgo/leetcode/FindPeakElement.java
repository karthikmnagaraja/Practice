package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 3/12/2015.
 */
public class FindPeakElement {
    public int findPeakElement(int[] num, int start, int end) {
        if(end-start==1) return start;

        int mid=(start+end )/2;

        int l=findPeakElement( num,  start, mid);
        int r=findPeakElement( num, mid,  end);

        return num[l]>num[r]?l:r;
    }

    public int findPeakElement(int[] num) {
        return findPeakElement(num, 0, num.length);
    }
}
