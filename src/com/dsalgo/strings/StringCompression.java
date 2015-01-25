package com.dsalgo.strings;

/**
 * @author KarthikMNagaraja.
 * Cracking the Coding Interview
 * Problem No: 1.5
 */
public class StringCompression {

    public String stringCompress(String str){
        int count=1;
        char lastCh=str.charAt(0);
        StringBuilder sb= new StringBuilder();
        for (int i=1;i<str.length();i++){
            if(str.charAt(i)==lastCh){
                count++;
            }else{
                sb.append(lastCh);
                lastCh=str.charAt(i);

                sb.append(count);
                count=1;
            }
        }
        sb.append(str.charAt(str.length()-1));
        sb.append(count);
        String ret= sb.toString();
        return ret.length()>=str.length()?str:ret;

    }

    public static void main(String[] args) {
        StringCompression s= new StringCompression();
        System.out.println(s.stringCompress("aaabbbcccaa"));
        System.out.println(s.stringCompress("aabbccaa"));
        System.out.println(s.stringCompress("abcd"));
    }
}
