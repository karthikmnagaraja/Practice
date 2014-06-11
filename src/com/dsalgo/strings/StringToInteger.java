package com.dsalgo.strings;

/**
 * Created by smikmn0 on 6/10/2014.
 */
public class StringToInteger {
    public static void main(String[] args) {
      /*  System.out.println(StringToInteger.stringToInteger("+112243"));
        System.out.println(StringToInteger.stringToInteger("-11224"));

        System.out.println(StringToInteger.stringToInteger("18"));

        System.out.println(StringToInteger.stringToInteger("-1"));

        System.out.println(StringToInteger.stringToInteger("+0"));
        System.out.println(StringToInteger.stringToInteger("   "));*/
        System.out.println(StringToInteger.stringToInteger("    123.123 "));
        System.out.println(StringToInteger.stringToInteger(""));
    }

    public static int stringToInteger(String str){

        int sign=1;
        int index=0;
        str=str.trim();
        int len=str.length();
        if(len==0){
            return 0;
        }
        if(str.charAt(index)=='-'){
            sign=-1;
            index++;
        }else if(str.charAt(index)=='+'){
                      index++;
        }
        long num=0;
        for(;index<len;index++){

            if( str.charAt(index)<'0'|| str.charAt(index)>'9'){
                break;
            }
            num=num*10+( str.charAt(index)-'0');


        }
        num=num*sign;
        if(num>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(num<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)num;
    }
}
