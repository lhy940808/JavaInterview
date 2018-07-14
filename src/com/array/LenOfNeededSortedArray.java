package com.array;

//问题：给定一个无序数组，求出需要排序的最短子数组的长度


public class LenOfNeededSortedArray {

	public static void main(String[] args) {
		int[] arr = {1,8,5,7,10};
		
		System.out.println("length is : " + new LenOfNeededSortedArray().getMinLen(arr));
	}
	
	public int getMinLen(int[] arr) {
		if (arr == null) {
			return 0;
		}
		
		//先从右到左遍历数组，寻找最小值，发现有值小于这个值，记下这个异常值的位置，一直到最左边出现这种情况的索引
		int min = arr[arr.length - 1];
		int left = arr.length - 1;
		for(int i = arr.length - 2; i > -1; i--) {
			if (arr[i] > min) {
				left = i;
			}else {
				min = Math.min(min, arr[i]);
			}
		}
		if (left == arr.length - 1) {
			return 0;
		}
		int max = arr[0];
		int right = 0;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] < max) {
				right = i;
			}else {
				max = Math.max(max, arr[i]);
			}
		}
		return right - left + 1;
	}
}
