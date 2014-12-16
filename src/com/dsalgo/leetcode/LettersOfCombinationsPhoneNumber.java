package com.dsalgo.leetcode;



import java.util.LinkedList;
import java.util.List;

/**
 * @author KarthikMNagaraja.
 */
public class LettersOfCombinationsPhoneNumber {

    public static void main(String[] args) {
        LettersOfCombinationsPhoneNumber a= new LettersOfCombinationsPhoneNumber();
        System.out.println(a.letterCombinations("23"));
        System.out.println(a.letterCombinations1("23"));
    }

    public List<String> letterCombinations1(String digits) {
        String[] numbers={"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> list= new LinkedList<String>();
        list.add("");
        for(int i=0;i<digits.length();i++){
                int num=digits.charAt(i)-'2';
               int size=list.size();
            for (int j = 0; j < size; j++) {
                String tmp=list.pop();

                for (int k = 0; k <numbers[num].length(); k++)
                    list.add(tmp+numbers[num].charAt(k));
               }
        }


        List<String> ret=new LinkedList<String>();
        ret.addAll(list);
        return ret;
    }

    public List<String> letterCombinations(String digits) {
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> list = new LinkedList<String>();
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '2';
            int size = list.size();
            for (int k = 0; k < size; k++) {
                String tmp = list.pop();
                for (int j = 0; j < letters[num].length(); j++)
                    list.add(tmp + letters[num].charAt(j));
            }
        }
        List<String> rec = new LinkedList<String>();
        rec.addAll(list);
        return rec;
    }
}
