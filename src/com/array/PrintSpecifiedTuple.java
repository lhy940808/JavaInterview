package com.array;

import java.util.HashMap;
import java.util.Map;



//���⣺ ���ظ���ӡһ���ź����������ָ����Ϊk�Ķ�Ԫ�����Ԫ��

public class PrintSpecifiedTuple {
	public static void main(String[] args) {
		int[] arr = {1,1,1,1,1,2,2,3,4,6,6,7};
		new PrintSpecifiedTuple().printTwoTuple(arr, 4);
		System.out.println();
		new PrintSpecifiedTuple().printTwoTuple2(arr, 4);
		System.out.println();
		new PrintSpecifiedTuple().printThreeTuple(arr, 8);
		
	}
	
	//���Ԫ��
	public void printTwoTuple(int[] arr, int k) {
		if (arr == null || arr.length < 2) {
			return;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		//����һ�����飬��ÿ�����ŵ�������
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			}else {
				map.put(arr[i], 1);
			}
		}
		
		//�ٱ���һ�飬Ѱ�ҵ�ǰԪ�����ĸ�Ԫ���ۼӺ�Ϊk
		for (int i = 0; i < arr.length;) {
			int nextValue = k - arr[i];
			if (nextValue >= arr[i] && map.containsKey(nextValue)) {
				System.out.print("<" + arr[i] + "," + nextValue + ">  ");
			}
			i = i + map.get(arr[i]);
		}
	}
	
	// �������� �ö��ֲ��ҵ�˼��ȥ��
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
	
	//����Ԫ�飬����Ԫ������
	public void printThreeTuple(int[] arr, int k) {
		if (arr == null || arr.length < 3) {
			return;
		}
		
		//˼�룺�������飬��һ������֪��ʣ���������������������ҵ�����
		//���ڼ����ظ�Ԫ�أ�ֻҪ��һ��Ԫ�ز���ͬ����
		
		for (int i = 0; i < arr.length - 2; i++) {
			if (i == 0 || arr[i] != arr[i - 1]) {
				printTuple(arr, i, k);
			}
		}
	}
	
	public void printTuple(int[] arr, int start, int k) {
		//��[start + 1, arr.length - 1] ��ʼѰ����������Ԫ��
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
