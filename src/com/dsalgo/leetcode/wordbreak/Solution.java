package com.dsalgo.leetcode.wordbreak;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KarthikMNagaraja.
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0 || dict == null)
            return true;

        int length = s.length();

        //dp[i] is true when the substring from i to the end can be partitioned
        boolean[] dp = new boolean[length+1];

        //empty string can be partitioned for sure
        dp[0] = true;

        //bottom up dp, start from the end
        for(int i = 0;i<=length;i++){
            for(int j = 0;j < i;j++){
                String sub = s.substring(j,i);
//                System.out.println(sub);
                if(dict.contains(sub) == true&&dp[j]==true){
                    dp[i]= true;
                    break;  //break, just jump out current level of loop
                }
            }
            if(dp[length]){
                break;
            }

        }

        return dp[length];
    }
    public static void main(String[] args) {
        Solution s= new Solution();
        Set<String> dict= new HashSet<String>();
        dict.add("leet");
        dict.add("code");
        dict.add("cd");
        dict.add("b");
        dict.add("a");
        dict.add("abc");


        System.out.println(s.wordBreak("leetcode",dict));
        System.out.println(s.wordBreak("ab",dict));
        System.out.println(s.wordBreak("abcd",dict));
    }
}
