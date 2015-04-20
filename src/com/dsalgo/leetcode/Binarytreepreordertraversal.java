package com.dsalgo.leetcode;


import java.util.ArrayList;
import java.util.List;
/**
 * Created by knagaraj on 8/12/2014.
 * 67 / 67 test cases passed.
 Status: Accepted
 Runtime: 416 ms
 */

/**
 * Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,2,3].
 */
public class Binarytreepreordertraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result= new ArrayList<Integer>();
        if(root==null) return result;

        preorderTraversal( root,   result );
        return result;
    }

    public   void preorderTraversal(TreeNode root,  List<Integer> result ) {
        if(root==null) return;
        result.add(root.val);
        preorderTraversal( root.left,   result );
        preorderTraversal( root.right,   result );

    }
}
