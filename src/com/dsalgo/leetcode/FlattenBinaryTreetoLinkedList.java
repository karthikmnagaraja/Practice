package com.dsalgo.leetcode;

import com.dsalgo.leetcode.common.TreeNode;
import java.util.Stack;
/**
 * Created by knagaraj on 8/19/2014.
 * 225 / 225 test cases passed.
 Status: Accepted
 Runtime: 496 ms
 */

/**
 * Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6

 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack= new Stack<TreeNode>();
        TreeNode node=root;
        while(node!=null||!stack.isEmpty()){

            if(node.right!=null)
                stack.push(node.right);

            if(node.left!=null)
            {
                node.right=node.left;
                node.left=null;
            }else if(!stack.isEmpty()){
                TreeNode p=stack.pop();
                node.right=p;
            }
            node=node.right;



        }

    }
}
