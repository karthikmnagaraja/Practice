package com.dsalgo.leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by knagaraj on 8/12/2014.
 * 67 / 67 test cases passed.
 *Status: Accepted
 *Runtime: 352 ms
 */

/**
 * Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;

        postorderTraversal(root, result);
        return result;

    }

    public void postorderTraversal(TreeNode root, List<Integer> result) {

        if (root == null) return;
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);

        result.add(root.val);

    }
}
