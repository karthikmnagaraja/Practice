package com.dsalgo.leetcode.WildCardMatching;

/**
 * @author KarthikMNagaraja.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int slen=s.length();
        int plen=p.length();
        int i=0,j=0;
        char[] sa=s.toCharArray();
        char[] pa=p.toCharArray();
        int star=-1;
        while(slen>i){
            System.out.println(i+" "+sa[i]+" "+j+" "+pa[j]);
            if(sa[i]==pa[j]||pa[j]=='?'){
                i++;j++;
            }
            else if(j<plen&&pa[j]=='*') {
                star=j;

                j++;
                //continue;
            }
            else if(pa[star-1]==sa[i]){
                    i++;
            }else if(pa[star-1]!=sa[i]){
                star+=1;
            }
            else{ return false;
            }
        }
        while(j<plen&& pa[j]=='*'){
            j++;

        }

        return j==plen&&i==slen;

    }

    public boolean isMatch2(String s, String p) {
        if (s == null || p == null) return false;
        if (s.equals(p)) return true;
        int m = s.length();
        int n = p.length();
        int posS = 0;
        int posP = 0;
        int posStar = -1;
        int posOfS = -1;
        //if posS == posP || posP == '?', ++posS and ++posP.
        //posOfS, posStar, record the positon of '*' in s and p, ++posP and go on.
        //if not match, go back to star, ++posOfS
        while (posS < m) {
            if (posP < n && (s.charAt(posS) == p.charAt(posP) || p.charAt(posP) == '?')) {
                ++posS;
                ++posP;
            }
            else if (posP < n && p.charAt(posP) == '*') {
                posStar = posP;
                posOfS = posS;
                ++posP;
                continue;
            }
            else if (posStar != -1) {
                posS = posOfS;
                posP = posStar + 1;
                ++posOfS;
            }
            else {
                return false;
            }
        }
        while (posP < n && p.charAt(posP) == '*') {
            ++posP;
        }

        return posS == m && posP == n;
    }
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.isMatch2("aab", "a*b"));
        System.out.println(s.isMatch2("b", "a*b"));

    }
}