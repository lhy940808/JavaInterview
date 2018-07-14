package com.dynamic;

//问题：求最长递增子序列
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
	
	//方法一：使用动态规划进行
	
	public int[] lis1(int[] arr) {
		if (arr == null || arr.length < 1) {
			return null;
		}
		int[] dp = getDp1(arr);
		return generateLIS(arr, dp);
	}
	public int[] getDp1(int[] arr) {
		
		//dp[i]的意思表示以在位置i处结尾的数的最长递增子序列的长度
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			//以在i处结尾的数字，可以向右找到比i处小的数，比较各个比i小的数上最长子序列的长度即可
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
		//找到dp中的最大值
		int max = dp[0];
		int index = 0;
		
		for (int i = 1; i < dp.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
				index = i;
			}
		}
		
		//从index处开始寻找递增序列
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
	
	
	//方法二：优化上述方法，利用二分查找
	public int[] lis2(int[] arr) {
		if (arr == null || arr.length < 1) {
			return null;
		}
		int[] dp = getDp2(arr);
		return generateLIS(arr, dp);
	}
	
	public int[] getDp2(int[] arr) {
		//dp是记录以i结尾的最长子数组的长度
		int[] dp = new int[arr.length];
		//表示长度为i+1的结尾数字是什么
		int[] ends = new int[arr.length];
		
		int right = 0;//表示ends的有效区间的结尾索引
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
