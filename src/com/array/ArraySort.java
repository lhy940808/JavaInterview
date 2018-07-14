package com.array;
//���⣺ һ�����鳤��ΪN ��ֵ��1-N ����������������Ҫ��ʱ�临�Ӷ�ΪO(n) �ռ临�Ӷ�Ϊ1

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
	
	//�Լ����뷨 �ݹ��˼·���������Ϊ�����֣���һ������ʣ�����
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
	
	//�뷨������Ϊ�൱����1-n�����ţ�������Ҫ��λ����ô����ԭʼ���飬ͨ����ֵ��֪��������������λ�ã�������
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
	
	//���з�����
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
