package com.dsalgo.leetcode;


import java.util.ArrayList;

/**
 * @author KarthikMNagaraja.
 */
public class ZigzagConversion {

    public String convert(String s, int nRows) {
        if(s==null||nRows<=1||s.length()<=1) return s;
        ArrayList<StringBuilder> strArr= new ArrayList<StringBuilder>();

        for (int i = 0; i <nRows ; i++) {
            strArr.add( new StringBuilder());
        }

        int rows=0;
        boolean down=false;
        for (int i = 0; i <s.length() ; i++) {
            strArr.get(rows).append(s.charAt(i));
            if(rows==0) down=true;
            else if(rows==nRows-1) down=false;

            if(down)rows++;else rows--;
        }

        StringBuilder sb= new StringBuilder();
        for (int i = 0; i <strArr.size() ; i++) {
            sb.append(strArr.get(i));

        }
        return sb.toString();
    }

    public String convert2(String s, int nRows) {
        if(s==null||nRows<=1||s.length()<=1) return s;
        StringBuilder sb= new StringBuilder();
        int size= 2*nRows-2;
        for (int i = 0; i <nRows ; i++) {
            for (int j = i; j <s.length() ; j+=size) {
                sb.append(s.charAt(j));

                if(i!=0&&i!=nRows-1&&j+size-2*i<s.length())
                    sb.append(s.charAt(j+size-2*i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion s= new ZigzagConversion();
        assert(s.convert2("PAYPALISHIRING", 3).equalsIgnoreCase("PAHNAPLSIIGYIR"));
        System.out.println(s.convert2("ABCDE", 4));
        System.out.println(s.convert2("PAYPALISHIRING", 3));
    }
}
