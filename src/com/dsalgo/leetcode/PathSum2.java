package com.dsalgo.leetcode;

import com.dsalgo.leetcode.common.TreeNode;

import java.util.ArrayList;

/**
 * Created by knagaraj on 8/19/2014.
 *
 114 / 114 test cases passed.
 Status: Accepted
 Runtime: 512 ms
 */

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

 */
public class PathSum2 {


        public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
            ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>(0);
            pathSum(root, sum, res, new ArrayList<Integer>()) ;
            return res;
        }

        public void pathSum(TreeNode root, int sum,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list) {
            if(root==null)
                return;
            sum-=root.val;
            list.add(root.val);
            if(root.left==null&&root.right==null&&sum==0){
                res.add(new ArrayList<Integer>(list));

            }
            else{
                pathSum(root.left,  sum, res, list) ;
                pathSum(root.right,  sum, res,  list);
            }
            list.remove(list.size()-1);
        }
    }

