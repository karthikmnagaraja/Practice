package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 4/20/2015.
 */
public class Numberof1Bits {

        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count=0;
            while(n!=0){
                n=n&(n-1);
                count++;
            }
            return count;
        }

}
