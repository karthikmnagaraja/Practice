package com.dsalgo.strings;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Created by smikmn0 on 6/10/2014.
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(IntegerToRoman.RomanNumerals(19));
    }


    public static String RomanNumerals(int intValue) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
            int matches = intValue/entry.getValue();
            res += repeat(entry.getKey(), matches);
            intValue = intValue % entry.getValue();
        }
        return res;
    }
    public static String repeat(String s, int n) {
        if(s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
    
    
    
     public String intToRoman(int num) {
        
        String [] key={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int [] value={1000,900,500,400,100,90,50,40,10,9,5,4,1};
  
        String res = "";
        for(int i=0;i<key.length;i++){
            if(num>=value[i]){
            int matches = num/value[i];
            if(matches>0)
                for(int j = 0; j < matches; j++) res+=key[i];
             num = num % value[i];
                
            }
        }
        return res;
    }
}
