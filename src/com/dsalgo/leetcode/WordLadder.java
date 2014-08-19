package com.dsalgo.leetcode;

import java.util.Set;
import java.util.LinkedList;
/**
 * Created by knagaraj on 8/19/2014.
 *
 * 37 / 37 test cases passed.
 * Status: Accepted
 * Runtime: 744 ms
 */

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5
 */
public class WordLadder {

        public int ladderLength(String start, String end, Set<String> dict) {

            LinkedList<Integer> counter= new LinkedList<Integer>();
            LinkedList<String> queue= new LinkedList<String>();
            queue.add(start);
            counter.add(1);

            while(!queue.isEmpty()){
                String word= queue.pop();
                int curLevel=counter.pop();

                if(word.equals(end))    return curLevel;
                for(int i=0;i<word.length();i++){
                    char[] arr= word.toCharArray();
                    for(char c='a';c<='z';c++){
                        arr[i]=c;
                        String str= new String(arr);
                        if(dict.contains(str)){
                            counter.add(curLevel+1);
                            queue.add(str);
                            dict.remove(str);
                        }
                    }
                }
            }
            return 0;
        }

    }

