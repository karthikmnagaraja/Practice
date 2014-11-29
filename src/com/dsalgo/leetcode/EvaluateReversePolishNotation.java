package com.dsalgo.leetcode;

import java.util.Stack;
/**
 * Created by knagaraj on 8/12/2014.
 * 18 / 18 test cases passed.
 *Status: Accepted
 *Runtime: 480 ms
 */
/*
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {

    public  int evalRPN(String[] tokens) {
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
