package com.dsalgo.dp;

/**
 * @author KarthikMNagaraja.
 * http://www.geeksforgeeks.org/longest-common-substring/
 */
public class LongestCommonSubstring {

    private int lcs(String a, String b){
        int alen= a.length();
        int blen=b.length();
        int result=0;
       int[][] dp=new int[alen+1][blen+1];
        for (int i = 0; i <alen ; i++) {
            for (int j = 0; j <blen ; j++) {
                if(i==0||j==0)dp[i][j]=0;
                else if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    result=result>dp[i][j]?result:dp[i][j];
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonSubstring lcs= new LongestCommonSubstring();
        System.out.println(lcs.lcs("OldSite:GeeksforGeeks.org","NewSite:GeeksforQuiz.com"));

    }
}
