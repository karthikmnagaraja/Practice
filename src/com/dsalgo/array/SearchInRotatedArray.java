package com.dsalgo.array;

/**
 * Created by knagaraj on 12/16/2014.
 */
public class SearchInRotatedArray {
    public int search(int[] A, int target) {
        if(A==null||A.length==0) return -1;
        int start=0,end=A.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(A[mid]==target) return mid;
            if(A[start]<=A[mid]){
                if(A[start]<=target && A[mid]>target){
                    end=mid-1;
                }else start=mid+1;


            }else{
                if(A[end]>=target && A[mid]<target){
                    start=mid+1;

                }else end=mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a={4,5,6,7,8,0,1,2,3};
        SearchInRotatedArray s= new SearchInRotatedArray();
        System.out.println(s.search(a,5));
        System.out.println(s.search(a,0));
        System.out.println(s.search(a,4));
        System.out.println(s.search(a,3));
    }
}
