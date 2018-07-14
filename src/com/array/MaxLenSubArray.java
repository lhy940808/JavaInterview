package com.array;

import java.util.Stack;
//����:����һ������arr�����������򣬵�ÿ��ֵ��Ϊ�������ڸ���һ������k����arr������������
//������Ԫ����Ӻ�Ϊk��������鳤��

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
		
		//�Լ����뷨���ö�̬�滮��     
		int[][] dp = new int[arr.length][k + 1];
		
		int minValue = Integer.MIN_VALUE;
		//���߽縳ֵ
		for (int j = 1; j <= k; j++) {
			dp[0][j] = arr[0] == j ? 1 : minValue;
		}
		
		//��ʼ����������ֵ
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
		//��������
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
	
	//��ȷ��
	public int maxLen2(int[] arr, int k) { 
		if (arr == null || arr.length < 1             ) {
			return 0;
		}
		int left = 0;
		int right = 0;
		int sum = arr[left];//��ʾarr[left..right]������֮��
		int len = 0;// ��¼������������������鳤��
		while(right < arr.length) {
			if (sum == k){
				//��ʱ�ҵ�һ������������������
				len = Math.max(len, right - left + 1);
				sum-= arr[left];
				left++;
			}else if (sum > k) {
				
				//��ʱleft...right֮�������ʹ���k ��ôleft..right+ 1�϶����Ǵ��ڿ��� �������Ҫ��ʼ��λ��
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
