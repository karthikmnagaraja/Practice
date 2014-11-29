package com.dsalgo.leetcode.EvaluateReversPolishNotation;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author KarthikMNagaraja.
 */
public class Solution {
    public static void main(String[] args) {
        String []tokens={"2", "1", "+", "3", "*"};
        String [] in={"3","-4","+"};
        String operators="*+/-";
        System.out.println(evalRPN(in));
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<Integer>();
        String operators="*+/-";


        for(String in:tokens)
        {
            if(operators.contains(in)){
                int b=stack.pop();
                int a= stack.pop();
                int pos=operators.indexOf(in);
                switch (pos){
                    case 0:stack.push(a*b);break;
                    case 1:stack.push(a+(b));break;
                    case 2: stack.push(a/b);break;
                    case 3:stack.push(a-b);break;
                }
            }else{

               stack.push(Integer.parseInt(in));
            }
        }
        return stack.pop();
    }


}