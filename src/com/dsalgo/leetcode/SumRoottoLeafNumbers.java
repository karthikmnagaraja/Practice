package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 8/12/2014.
 109 / 109 test cases passed.
 Status: Accepted
 Runtime: 424 ms
 */

import com.dsalgo.leetcode.common.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;

        int[] sum={0};
        verticalSum( root, 0,sum);
        return sum[0];
    }

    private void verticalSum(TreeNode root, int currentSum, int[] sum){
        if(root==null) return;
        currentSum=currentSum*10+root.val;
        if(root.left==null&&root.right==null){
            sum[0]+=currentSum;
            return;
        }

        verticalSum(root.left,currentSum,sum);

        verticalSum(root.right,currentSum,sum);
    }

}
