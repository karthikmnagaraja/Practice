package com.dsalgo.leetcode;
import com.dsalgo.leetcode.common.TreeNode;
/**
 * Created by knagaraj on 8/19/2014.
 *
 114 / 114 test cases passed.
 Status: Accepted
 Runtime: 404 ms
 */
/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

        For example:
        Given the below binary tree and sum = 22,
        5
        / \
        4   8
        /   / \
        11  13  4
        /  \      \
        7    2      1
        return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

        Have you been asked this question in an interview?
*/

public class PathSum {

        public boolean hasPathSum(TreeNode root, int sum) {
            if(root==null)  return false;
            else if(root.right==null&&root.left==null) return root.val==sum;

            return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
        }

}
