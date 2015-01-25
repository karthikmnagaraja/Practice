package com.dsalgo.strings;

/**
 * @author KarthikMNagaraja.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-123));
        System.out.println(reverse(103));

    }
    public static int reverse(int x) {
        int num=0; int mul=1;
        if(x<0){
            mul=-1;
            x*=mul;
        }
        while(x>0){
            num=num*10+x%10;
            x=x/10;

        }
        return num*mul;

    }
}
