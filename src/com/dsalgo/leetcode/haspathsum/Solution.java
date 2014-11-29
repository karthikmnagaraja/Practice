package com.dsalgo.leetcode.haspathsum;

import com.dsalgo.leetcode.common.TreeNode;

/**
 * @author KarthikMNagaraja.
 */
public class Solution {



    public boolean hasPathSum(TreeNode root, int sum) {

            if (root == null) return false;

            if (root.left == null && root.right == null ) return root.val== sum;


             return hasPathSum(root.left, sum-root.val)||  hasPathSum(root.right, sum-root.val);



    }

    public static void main(String[] args) {
        TreeNode node7= new TreeNode(7);
        TreeNode node2= new TreeNode(2);TreeNode node1= new TreeNode(1);
        TreeNode node11= new TreeNode(11,node7,node2);
        TreeNode node4= new TreeNode(4,node11,null);
        TreeNode node13= new TreeNode(13);TreeNode node42= new TreeNode(4,node1,null);
        TreeNode node8= new TreeNode(8,node13,node42);
        TreeNode node5= new TreeNode(5,node4,node8);
        Solution s= new Solution();
        System.out.println(s.hasPathSum(node5,22));

    }
}
