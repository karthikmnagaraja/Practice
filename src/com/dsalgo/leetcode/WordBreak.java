package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 8/12/2014.
 * 22 / 22 test cases passed.
 Status: Accepted
 Runtime: 316 ms
 */

import java.util.Set;

/**
 * s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if (dict.contains(s)) return true;

        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (!t[i])  continue;
            for (String word : dict) {
                int len = word.length();
                int end = i + len;

                if (end > s.length()) continue;
                if (t[end]) continue;

                if (s.substring(i, end).equals(word)) t[end] = true;

            }

        }

        return t[s.length()];
    }

    public boolean wordBreakUsingDp(String s, Set<String> dict) {
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

}
