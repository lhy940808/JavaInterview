package com.array;

import java.util.HashMap;
import java.util.Map;



//问题： 不重复打印一个排好序的数组中指定和为k的二元组和三元组

public class PrintSpecifiedTuple {
	public static void main(String[] args) {
		int[] arr = {1,1,1,1,1,2,2,3,4,6,6,7};
		new PrintSpecifiedTuple().printTwoTuple(arr, 4);
		System.out.println();
		new PrintSpecifiedTuple().printTwoTuple2(arr, 4);
		System.out.println();
		new PrintSpecifiedTuple().printThreeTuple(arr, 8);
		
	}
	
	//求二元组
	public void printTwoTuple(int[] arr, int k) {
		if (arr == null || arr.length < 2) {
			return;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		//遍历一遍数组，将每个数放到集合里
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			}else {
				map.put(arr[i], 1);
			}
		}
		
		//再遍历一遍，寻找当前元素与哪个元素累加和为k
		for (int i = 0; i < arr.length;) {
			int nextValue = k - arr[i];
			if (nextValue >= arr[i] && map.containsKey(nextValue)) {
				System.out.print("<" + arr[i] + "," + nextValue + ">  ");
			}
			i = i + map.get(arr[i]);
		}
	}
	
	// 方法二， 用二分查找的思想去做
	public void printTwoTuple2(int[] arr, int k) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int left = 0;
		int right = arr.length - 1;
		
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum > k) {
				right--;
			}else if (sum < k) {
				left++;
			}else {
				if (left == 0 || arr[left] != arr[left - 1]) {
					System.out.print("<" + arr[left] + "," + arr[right] + ">  ");
				}
				left++;
				right--;
			}
			}
		
	}
	
	//求三元组，跟二元组相似
	public void printThreeTuple(int[] arr, int k) {
		if (arr == null || arr.length < 3) {
			return;
		}
		
		//思想：遍历数组，第一个数已知，剩余两个数，用上述方法找到即可
		//至于鉴别不重复元素，只要第一个元素不相同即可
		
		for (int i = 0; i < arr.length - 2; i++) {
			if (i == 0 || arr[i] != arr[i - 1]) {
				printTuple(arr, i, k);
			}
		}
	}
	
	public void printTuple(int[] arr, int start, int k) {
		//从[start + 1, arr.length - 1] 开始寻找另外两个元素
		int left = start + 1;
		int right = arr.length - 1;
		int remainedSum = k - arr[start];
		
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum > remainedSum) {
				right--;
			}else if (sum < remainedSum) {
				left++;
			}else{
				if (left == start + 1 || arr[left] != arr[left - 1]){
					System.out.print("<" + arr[start] + "," + arr[left] + "," + arr[right] + ">");
				}
				left++;
				right--;
			}
		}
	}
}
