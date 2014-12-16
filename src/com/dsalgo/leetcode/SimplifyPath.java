package com.dsalgo.leetcode;

import java.util.LinkedList;

/**
 * @author KarthikMNagaraja.
 */
public class SimplifyPath {


    public String simplifyPath(String path) {
        LinkedList<String> list= new LinkedList<String>();

        String[] paths= path.split("\\/+");
        for (String folder:paths){
            if(folder.length()>0) {
                if(folder.equalsIgnoreCase("..")){
                    if(list.size()>0)list.removeLast();
                }else {
                    list.addLast(folder);
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        for (String element:list) {
            sb.append("/").append(element);
        }

        return sb.toString().length()>0?sb.toString():"/";

    }

    public static void main(String[] args) {
        SimplifyPath s= new SimplifyPath();
        System.out.println(s.simplifyPath("/home/"));
        System.out.println(s.simplifyPath("/a/./b/../../c/"));

        System.out.println(s.simplifyPath("/home//foo/"));


    }

}
