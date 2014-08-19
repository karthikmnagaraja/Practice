package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 8/19/2014.
 *
 * 475 / 475 test cases passed.
 * Status: Accepted
 * Runtime: 384 m
 */

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */


public class ValidPalindrome {
    public boolean isPalindrome(String s) {


        s=s.toLowerCase().trim();

        char[] arr=s.toCharArray();

        int i=0,j=arr.length-1;

        while(i<j){
            while(check(arr[i])&&i<j){
                i++;
            }
            while(check(arr[j])&&i<j){
                j--;
            }
            if(arr[i]!=arr[j]){
                return false;
            }

            i++;
            j--;
        }
        return true;


    }

    private boolean check(char c){

        if('a'<=c && 'z'>=c) return false;
        if('0'<=c  &&'9' >=c) return false;


        return true;
    }
}
