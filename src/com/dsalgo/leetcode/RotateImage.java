package com.dsalgo.leetcode;

/**
 * Created by knagaraj on 12/16/2014.
 */
public class RotateImage {

    public void rotate(int [][]matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;

        int n=matrix.length;

        for (int i = 0; i <n/2 ; i++) {
            for (int j = 0; j < Math.ceil(n/2.0) ; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }

        }

    }

    public static void main(String[] args) {
        RotateImage r= new RotateImage();
        int[][]matrix={{1,2,3},{4,5,6},{7,8,9}};

        r.rotate(matrix);
        System.out.println("{");
        for (int i = 0; i <matrix.length ; i++) {
            System.out.print("{");
            for (int j = 0; j <matrix[0].length ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("}");
        }
        System.out.println("}");
    }

}
