package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 6/1/2015.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.isEmpty()||s.length()==0||t.length()==0||s.isEmpty()) return "";
        int[] expected= new int[256];
        int[] appeared= new int[256];
        for (int i = 0; i < t.length(); i++) {
            expected[t.charAt(i)]++;
        }
        int start=0,minStart=0,minLen=Integer.MAX_VALUE;
        int matched=0;

        for (int end = 0; end <s.length() ; end++) {

            if(expected[s.charAt(end)]>0){
                if(expected[s.charAt(end)]>appeared[s.charAt(end)]){
                    matched++;
                }
                ++appeared[s.charAt(end)];
                if(matched==t.length()){
                    while(expected[s.charAt(start)]==0||appeared[s.charAt(start)]>expected[s.charAt(start)]){
                        if(appeared[s.charAt(start)]>expected[s.charAt(start)]) appeared[s.charAt(start)]--;
                        start++;
                    }
                    if(minLen>end-start+1){
                        minStart=start;
                        minLen=end-start+1;
                    }
                }
            }
        }

        return matched<t.length()?"":s.substring(minStart,minLen+minStart);
    }

    public static void main(String[] args) {
        String s="bbcbcbccbbaaabacb",t="abca";
        MinimumWindowSubstring m= new MinimumWindowSubstring();
        //String p=m.minWindow(s, t);
        for (int i = 0; i <s.length() ; i++) {
            System.out.print(s.charAt(i) + "" + i);
        }
        System.out.println();
        String p=m.minWindow(s, t);
        System.out.println(p.equalsIgnoreCase("abac"));
        System.out.println(p);
    }
}
