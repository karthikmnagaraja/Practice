package com.dsalgo.leetcode;

/**
 * @author KarthikMNagaraja.
 * MaxSum[j]=Max{MaxSum[j-1]+A[j],A[j]}
 */
public class MaximumSubArray {
    public int maxSubArray(int[] A) {
        if(A==null||A.length==0) return 0;
        int maxSum=A[0],curMax=A[0];
        for (int i = 1; i <A.length ; i++) {
            curMax=curMax>curMax+A[i]?curMax:curMax+A[i];
            maxSum=maxSum>curMax?maxSum:curMax;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubArray m= new MaximumSubArray();
        int[] A1={0,-2,0,0,0,0,-1};
        int[] A2={0,-2,0,1,2,3,-1};
        int[] A3={-1,-2,0,-5,-4,-2,-1};
        System.out.println(m.maxSubArray(A1));
        System.out.println(m.maxSubArray(A2));
        System.out.println(m.maxSubArray(A3));
    }
}
