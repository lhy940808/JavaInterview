package com.array;
//问题：给定一个数组，求最大累加和
public class MaxSumSubArray {

	public static void main(String[] args) {
		int[] arr = {1,2,6,-3,2,2,1};
		System.out.println("max sum is : " + new MaxSumSubArray().maxSum(arr));
	}
	
	public int maxSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;//用来记录遍历过程中出现的最大累加和
		int cur = 0;//当前累加子数组的和
		for (int i = 0; i < arr.length; i++) {
			cur += arr[i];
			max = Math.max(max, cur);
			if (cur < 0) {
				cur = 0;
			}
		}
		return max;
	}
}
