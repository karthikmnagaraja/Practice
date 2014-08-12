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
}
