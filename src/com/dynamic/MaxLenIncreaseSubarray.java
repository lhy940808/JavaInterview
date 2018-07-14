package com.dynamic;

//���⣺�������������
public class MaxLenIncreaseSubarray {

	public static void main(String[] args) {
		int[] arr = {2,1,5,3,6,4,8,9,7};
		int[] lis = new MaxLenIncreaseSubarray().lis1(arr);
		
		for (int i = 0; i < lis.length; i++) {
			System.out.print(lis[i] + "  ");
		}
		System.out.println();
		int[] lis1 = new MaxLenIncreaseSubarray().lis2(arr);
		for (int i = 0; i < lis1.length; i++) {
			System.out.print(lis[i] + "  ");
		}
		
	}
	
	//����һ��ʹ�ö�̬�滮����
	
	public int[] lis1(int[] arr) {
		if (arr == null || arr.length < 1) {
			return null;
		}
		int[] dp = getDp1(arr);
		return generateLIS(arr, dp);
	}
	public int[] getDp1(int[] arr) {
		
		//dp[i]����˼��ʾ����λ��i����β����������������еĳ���
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			//����i����β�����֣����������ҵ���i��С�������Ƚϸ�����iС������������еĳ��ȼ���
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		return dp;
	}
	
	public int[] generateLIS(int[] arr, int[] dp) {
		//�ҵ�dp�е����ֵ
		int max = dp[0];
		int index = 0;
		
		for (int i = 1; i < dp.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
				index = i;
			}
		}
		
		//��index����ʼѰ�ҵ�������
		int[] lis = new int[max];
		int cur = max - 1;
		lis[cur] = arr[index--];
		while (cur >= 0 && index >= 0) {
			if (arr[index] < lis[cur] && dp[index] == cur) {
				lis[--cur] = arr[index];
			}
			index--;
		}
		return lis;
	}
	
	
	//���������Ż��������������ö��ֲ���
	public int[] lis2(int[] arr) {
		if (arr == null || arr.length < 1) {
			return null;
		}
		int[] dp = getDp2(arr);
		return generateLIS(arr, dp);
	}
	
	public int[] getDp2(int[] arr) {
		//dp�Ǽ�¼��i��β���������ĳ���
		int[] dp = new int[arr.length];
		//��ʾ����Ϊi+1�Ľ�β������ʲô
		int[] ends = new int[arr.length];
		
		int right = 0;//��ʾends����Ч����Ľ�β����
		dp[0] = 1;
		ends[0] = arr[0];
		
		int low = 0;
		int high = 0;
		int mid = 0;
		for (int i = 1; i < arr.length; i++) {
			low = 0;
			high = right;
			while (low <= high) {
				mid = (low + high) / 2;
				if (ends[mid] >= arr[i]) {
					high = mid - 1;
				}else {
					low = mid + 1;
				}
			}
			
			right = Math.max(right, low);
			dp[i] = low + 1;
			ends[low] = arr[i];
		}
		return dp;
	}
}
