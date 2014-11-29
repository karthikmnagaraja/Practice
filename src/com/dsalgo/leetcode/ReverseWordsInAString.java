package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 8/12/2014.
 * 22 / 22 test cases passed.
 * Status: Accepted
 * Runtime: 396 ms
 */


public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if(s==null||s.length()==0){
            return "";
        }

        String[] words = s.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = words.length - 1; i >= 0; --i) {

            if (!words[i].equals("")) {
                str.append(words[i]).append(" ");
            }
        }
        return  str.length() == 0 ? "" : str.substring(0, str.length() - 1);

    }
}
