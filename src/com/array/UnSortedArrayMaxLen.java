package com.array;

import java.util.HashMap;

//给定一个无序数组arr， 其中元素可正 可负 可0，给定一个整数k，求arr中所有的子数组累加和为k的最长子数组长度
public class UnSortedArrayMaxLen {
	public static void main(String[] args) {
		int[] arr = {22, 0, 2, -2, 13};
		int k = 2;
		System.out.println("max len is : " + new UnSortedArrayMaxLen().maxLen(arr, 0));
		System.out.println("max len is : " + new UnSortedArrayMaxLen().maxLenLessK(arr, k));
		System.out.println("max len is : " + new UnSortedArrayMaxLen().maxLenLessK2(arr, k));
	}
	
	//思想：用s(i)表示以i结尾的累加和，那么如果能找到s(j)= s(i) -k ,那么s(i) - s(j) = k
	//则此时(j+1....i)的累加和为k
	
	public int maxLen(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		int sum = 0;//表示当前数的累加和，也就是s(i)
		//还需要生成一个哈希表来存储累加和最早出现的位置
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int len = 0;
		map.put(0, -1);//表示什么都不加，累加和为0
		
		for (int i = 0; i <arr.length; i++) {
			sum += arr[i];
			
			//判断sum-k是否存在
			if (map.containsKey(sum - k)) {
				len = Math.max(len, i - map.get(sum - k));
			}
			if (!map.containsKey(sum)){
				map.put(sum, i);
			}
		}
		return len;
		
	}
	
	//问题2：在上述问题改为累加和小于或者等于给定值的最长子数组长度
	
	public int maxLenLessK(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		//思路：生成一个累加和的数组，和一个记录左边最大和
		int[] sum = new int[arr.length + 1];
		int[] help = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			sum[i + 1] = sum[i] + arr[i];
		}
		
		int max = 0;
		for (int i = 1; i < sum.length; i++) {
			if (max < sum[i]) {
				max = sum[i];
			}
			help[i] = max;
		}
		int low = 0;
		int high = 0;
		int mid = 0;
		
		int len = 0;
		//有了以上两个数组就可以计算最长子数组长度了
		//原理：累加和小于k的最长子数组长度，可以想成 最早出现大于sum-k的数组
		for (int i = 0; i < arr.length; i++) {
			int restSum = sum[i + 1] - k;
			//在help中找到最早出现restSum的值
			low = 0;
			high = i;
			while (low <= high) {
				mid = (low + high) / 2;
				if (help[mid] >= restSum) {
					high = mid - 1;
				}else {
					low = mid + 1;
				}
			}
			//找到了
			if (low <= i) {
				len = Math.max(len, i - low + 1);
			} 
		}
		return len;
	}
	//书中的做法
	public int maxLenLessK2(int[] arr, int k) {
		int[] h = new int[arr.length + 1];
		int sum = 0;
		h[0] = sum;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			h[i + 1] = Math.max(h[i], sum);
		}
		
		sum = 0;
		int res = 0;
		int pre = 0;
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			pre = getLessIndex(h, sum - k);
			len = pre == -1 ? 0 : i -pre + 1;
			res = Math.max(res, len);
		}
		return res;
	}
	
	public int getLessIndex(int[] arr, int sum) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int res = -1;
		while(low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] >= sum) {
				res = mid;
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
        return res;		
	}
}
