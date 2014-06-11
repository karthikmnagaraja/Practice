package com.dsalgo.stack;

import java.util.Stack;
/**
 * @author KarthikMNagaraja.
 */
public class ValidateParenthesis {

    public static void main(String[] args) {
        String valid="()[]{}";
        String inValid="()[]{";
        ValidateParenthesis validate= new ValidateParenthesis();
        System.out.println(valid+"-->"+validate.ValidateParenthesis(valid));

        System.out.println(inValid+"-->"+validate.ValidateParenthesis(inValid));

    }
    public boolean ValidateParenthesis(String str){
        Stack<Character> stack= new Stack<Character>();
        for (int i = 0; i <str.length() ; i++) {
            char ch= str.charAt(i);
            if(isLeft(ch)){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(!matchRight(stack.pop(),ch)){
                    return false;
                }

            }
        }
        return stack.isEmpty()?true:false;

    }

    private boolean isLeft(char c){

        return (c=='{'||c=='['||c=='(');
    }
    private boolean matchRight(char c,char d){
        return (c=='{'&&d=='}')||(c=='['&&d==']')||(c=='('&&d==')');
    }
}
