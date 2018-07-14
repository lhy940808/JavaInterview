package com.array;
//���⣺����һ�����飬������ۼӺ�
public class MaxSumSubArray {

	public static void main(String[] args) {
		int[] arr = {1,2,6,-3,2,2,1};
		System.out.println("max sum is : " + new MaxSumSubArray().maxSum(arr));
	}
	
	public int maxSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;//������¼���������г��ֵ�����ۼӺ�
		int cur = 0;//��ǰ�ۼ�������ĺ�
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
