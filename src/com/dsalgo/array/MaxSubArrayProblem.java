package com.dsalgo.array;

/**
 * @author KarthikMNagaraja.
 */
public class MaxSubArrayProblem {

    public static int maxSubArray(int[] a) {

        int cumulativeSum = 0, overallSum = 0;

        for (int i = 0; i < a.length; i++) {
            cumulativeSum += a[i];
            cumulativeSum = Math.max(0, cumulativeSum);
            overallSum = Math.max(overallSum, cumulativeSum);
        }
        return overallSum;

    }

    public static void maxSubArrayWithBoundaries(int[] a) {
        int startIndex = 0, endIndex = 0, indexUntilNow = 0;
        int cumulativeSum = 0, overallSum = 0;
        for (int i = 0; i < a.length; i++) {
            cumulativeSum += a[i];
            if (cumulativeSum > overallSum) {
                overallSum = cumulativeSum;
                startIndex = indexUntilNow;
                endIndex = i;
            } else if (cumulativeSum < 0) {
                //ignore previous calculated sum and reset the index
                indexUntilNow = 1 + i;
                cumulativeSum = 0;
            }

        }

        System.out.println("start index " + startIndex);
        System.out.println("end index " + endIndex);
        System.out.println("overallSum " + overallSum);


    }

    public static void main(String[] args) {
        int[] intArr={3, -1, -1, -2, 1, 1, 2, 0, 0, 0 };

       // int[] intArr={3, -1, -1, -1, -1, -1, 2, 0, 0, 0 };
        //int[] intArr = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
        //int[] intArr={-6,-2,-3,-4,-1,-5,-5};
        maxSubArrayWithBoundaries(intArr);
    }
}
