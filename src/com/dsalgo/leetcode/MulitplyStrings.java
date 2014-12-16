package com.dsalgo.leetcode;

/**
 * @author KarthikMNagaraja.
 */
public class MulitplyStrings {

    public String multiply(String num1, String num2) {
        char[] n1=num1.toCharArray();
        char[] n2=num2.toCharArray();


        int[] num= new int[n2.length+n1.length];
        for (int i =0;i< n1.length;   i++) {

            int a=n1[n1.length-i-1]-'0';
            int carry=0;

            for (int j =0;j< n2.length;  j++) {
                int b=n2[n2.length-j-1]-'0';

                 num[i+j]+=carry+a*b;
                 carry=num[i+j]/10;
                num[i+j]%=10;

            }
            num[i+n2.length]+=carry;
        }
        boolean flag=true;

        StringBuilder sb= new StringBuilder();
        for (int i=num.length-1;i>=0; i--) {

            if(flag&&num[i]!=0) flag=false;
            if(!flag)
                sb.append(num[i]);

        }
        return sb.toString();

    }

    public static void main(String[] args) {
        MulitplyStrings m= new MulitplyStrings();

        System.out.println(m.multiply("123456789","987654321"));
    }



}
