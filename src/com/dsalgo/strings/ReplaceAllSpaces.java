package com.dsalgo.strings;

/**
 * @author KarthikMNagaraja.
 */
public class ReplaceAllSpaces {

    private void spacesReplace(char[] charArr,int length){
         int numberOfSpace=0,newlength=0;

        for (int i = 0; i <length ; i++)
                    if(charArr[i]==' ') numberOfSpace++;

        newlength=length+2*numberOfSpace;
        for (int i = length-1; i >=0 ; i--) {
            if(charArr[i]==' '){
                charArr[newlength-1]='0';
                charArr[newlength-2]='2';
                charArr[newlength-3]='%';
                newlength-=3;
            }else {
                charArr[newlength-1]=charArr[i];
                newlength--;
            }
        }


    }

    public static void main(String[] args) {
        String s="Jessy I Love You       ";
        ReplaceAllSpaces r= new ReplaceAllSpaces();
        char[] ch=s.toCharArray();
        r.spacesReplace(ch,16);
        System.out.println(new String(ch));
    }
}
