package com.dsalgo.leetcode;
/*
* Rotate an array of n elements to the right by k steps.
* 
*For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
* https://leetcode.com/problems/rotate-array/
*/
public class RotateArray {
     public void rotate(int[] nums, int j) {

         j%=nums.length;
        int k=nums.length-j;
        reverseArr(nums,0,k-1);
        reverseArr(nums,k,nums.length-1);

        reverseArr(nums, 0, nums.length-1);
       


    }

    public static void reverseArr(int[] arr, int left, int right){
	if(arr == null || arr.length == 1) 
		return;
 
	while(left < right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		left++;
		right--;
	}	
}
}
