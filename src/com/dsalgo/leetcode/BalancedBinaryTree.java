package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 8/19/2014.
 *
 226 / 226 test cases passed.
 Status: Accepted
 Runtime: 476 ms
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {

        if(root==null) return true;

        if(Math.abs(MaxDepth(root.left)-MaxDepth(root.right))>1) return false;
        else return isBalanced(root.left)&&isBalanced(root.right);
    }

    int MaxDepth(TreeNode node){
        if(node==null) return 0;
        int l=MaxDepth(node.left);
        int r=MaxDepth(node.right);

        return l>r?l+1:r+1;

    }


}
