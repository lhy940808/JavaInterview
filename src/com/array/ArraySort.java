package com.array;
//问题： 一个数组长度为N 数值是1-N 将这个数组进行排序，要求时间复杂度为O(n) 空间复杂度为1

public class ArraySort {
	public static void main(String[] args) {
		int[] arr = {1,4,3,5,2,8,7,6};
		new ArraySort().recursionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println("---------------------------");
		int[] arr1 = {1,4,3,5,2,8,7,6,10,9,12,14,11,13};
		new ArraySort().recursionSort(arr1);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + "  ");
		}
		System.out.println("---------------------------");
		int[] arr2 = {1,4,3,5,2,8,7,6,10,9,12,14,11,13};
		new ArraySort().recursionSort(arr2);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + "  ");
		}
	}
	
	//自己的想法 递归的思路，将数组分为两部分，第一个数和剩余的数
	public void recursionSort(int[] arr) {
		if (arr == null || arr.length == 1) {
			return;
		}
		sortCore(arr, 0);
	}
	
	public void sortCore(int[] arr, int index) {
		if (index == arr.length - 1) {
			return;
		}
		int min = arr[index];
		int minIndex = index;
		for (int i = index + 1; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
				minIndex = i;
			}
		}
		if (min != index) {
			swap(arr, index, minIndex);
		}
		sortCore(arr, index + 1);
	}
	
	public void swap (int[] arr, int i, int j) {
		int temp = arr[i];
	    arr[i] = arr[j];
		arr[j] = temp;
				
	}
	
	//想法二：因为相当于是1-n的乱排，现在需要归位，那么遍历原始数组，通过数值可知道该数在数组中位置，交即可
	public void sort2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = 0; i < arr.length;) {
			if (i != arr[i] - 1) {
				swap(arr, i, arr[i] - 1);
			}else {
				i++;
			}
		}
	}
	
	//书中方法二
	public void sort3(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int next = 0;
		int temp = 0;
		for (int i = 0; i < arr.length; i++){
			temp = arr[i];
			while (i + 1 != arr[i]) {
				next = arr[temp - 1];
				arr[temp - 1] = temp;
				temp = next;
			}
		}
	}
}
