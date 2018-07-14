package com.array;

import java.util.Stack;
//问题:给定一个数组arr，该数组无序，但每个值均为正数，在给定一个正数k，求arr的所有子数组
//中所有元素相加和为k的最长子数组长度

public class MaxLenSubArray {

	public static void main(String[] args) {
		int[] arr = {1,2,1,1,4,1};
		
		int k = 6;
		System.out.println("max length is : " + new MaxLenSubArray().maxLen(arr, k));
		System.out.println("max length is : " + new MaxLenSubArray().maxLen2(arr, k));
	}
	
	public int maxLen(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		
		//自己的想法：用动态规划做     
		int[][] dp = new int[arr.length][k + 1];
		
		int minValue = Integer.MIN_VALUE;
		//给边界赋值
		for (int j = 1; j <= k; j++) {
			dp[0][j] = arr[0] == j ? 1 : minValue;
		}
		
		//开始计算其他的值
		for (int i = 1; i < arr.length; i++)
			for (int j = 1; j <= k; j++) {
				if (arr[i] > j) {
					dp[i][j] = dp[i - 1][j];
				}else {
					if (dp[i - 1][j - arr[i]] == minValue && dp[i - 1][j] == minValue) {
						dp[i][j] = minValue;
					}else {
						dp[i][j] = Math.max(dp[i - 1][j - arr[i]] + 1, dp[i - 1][j]);
					}
				}
			}
		//将结果输出
		Stack<Integer> stack = new Stack<Integer>();
		int i = arr.length - 1;
		int j = k;
		while (i > 0 && j > 0) {
			if (arr[i] > j) {
				i--;
			}else if (dp[i - 1][j - arr[i]] + 1 > dp[i - 1][j]){
				stack.push(arr[i]);
				j-= arr[i];
				i--;
				
				
			}else {
				i--;
			}
		}
		if (dp[i][j] == 1) {
			stack.push(arr[i]);
		} 
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + "  ");
		}
		return dp[arr.length - 1][k];
	}
	
	//正确答案
	public int maxLen2(int[] arr, int k) { 
		if (arr == null || arr.length < 1             ) {
			return 0;
		}
		int left = 0;
		int right = 0;
		int sum = arr[left];//表示arr[left..right]的区间之和
		int len = 0;// 记录遍历过程中最长的子数组长度
		while(right < arr.length) {
			if (sum == k){
				//此时找到一个满足条件的子数组
				len = Math.max(len, right - left + 1);
				sum-= arr[left];
				left++;
			}else if (sum > k) {
				
				//此时left...right之间的数组和大于k 那么left..right+ 1肯定更是大于卡， 所以左边要开始移位了
				sum-=arr[left++];
			}else {
				right++;
				if (right == arr.length) {
					break;
				}
				sum += arr[right];
			}
		}
		return len;
	}
}
