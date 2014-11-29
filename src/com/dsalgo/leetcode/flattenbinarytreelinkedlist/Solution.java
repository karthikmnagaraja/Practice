package com.dsalgo.leetcode.flattenbinarytreelinkedlist;

import com.dsalgo.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * @author KarthikMNagaraja.
 */
public class Solution {

    public void flatten(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root=node;
        while (root != null || !stack.isEmpty()) {
            if (root.right != null) stack.push(root.right);
            else if (root.left != null) {
                root.right=root.left;
                root.left=null;
            }
            else if(!stack.isEmpty()){
                root.right=stack.pop();
            }
            root=root.right;
        }

    }
}
