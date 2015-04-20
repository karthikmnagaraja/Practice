package com.dsalgo.leetcode;

/**
 * @author KarthikMNagaraja.
 */
public class ValidateBinaryTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, int min, int max) {

        if(root==null) return true;

        if(root.val<min&&root.val>max) return false;

        return isValidBST(root.left,root.val,max)&& isValidBST(root.right,root.val, max);
    }

    public static void main(String[] args) {
        TreeNode node7= new TreeNode(7);
        TreeNode node2= new TreeNode(2);TreeNode node1= new TreeNode(1);
        TreeNode node11= new TreeNode(11,node7,node2);
        TreeNode node4= new TreeNode(4,node11,null);
        TreeNode node13= new TreeNode(13);TreeNode node42= new TreeNode(4,node1,null);
        TreeNode node8= new TreeNode(8,node13,node42);
        TreeNode node5= new TreeNode(5,node4,node8);
        ValidateBinaryTree b= new ValidateBinaryTree();
        //b.isValidBST();

    }
}
