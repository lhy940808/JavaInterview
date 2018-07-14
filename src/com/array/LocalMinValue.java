package com.array;

//问题：给定一个数组，有如下定义：
  /* 1 如果数组长度为1 那么arr[0]为局部最小
   2 如果数组长度N(N>1) 那么如果arr[0] < arr[1],那么arr[0]为局部最小 arr[N -1] < arr[N  2]，那么arr[N - 1]为局部最小
   如果有arr[i - 1] < arr[i] < arr[i + 1](0 < i < n - 1);
   如上，找出一个数组任意一个局部最小的位置*/
public class LocalMinValue {
	public static void main(String[] args) {
		int[] arr1 = {1};
		int[] arr2 = {1,2,3,4};
		int[] arr3 = {4,2,1};
		int[] arr4 = {6,5,2,4,8,10};
		int[] arr5 = {5,4,7,3,6,9};
		System.out.println("min value is : " + new LocalMinValue().minIndex(arr1));
		System.out.println("min value is : " + new LocalMinValue().minIndex(arr2));
		System.out.println("min value is : " + new LocalMinValue().minIndex(arr3));
		System.out.println("min value is : " + new LocalMinValue().minIndex(arr4));
		System.out.println("min value is : " + new LocalMinValue().minIndex2(arr5));
	}
	
	public int minIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int index = -1;
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1] && arr[i] < arr[ i - 1]) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public int minIndex2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			}else if (arr[mid] > arr[mid + 1]) {
				left = mid + 1;
			}else {
				return mid;
			}
		}
		return left;
	}

}
