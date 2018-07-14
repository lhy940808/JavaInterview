package com.array;

//���⣺����һ���������飬�����Ҫ��������������ĳ���


public class LenOfNeededSortedArray {

	public static void main(String[] args) {
		int[] arr = {1,8,5,7,10};
		
		System.out.println("length is : " + new LenOfNeededSortedArray().getMinLen(arr));
	}
	
	public int getMinLen(int[] arr) {
		if (arr == null) {
			return 0;
		}
		
		//�ȴ��ҵ���������飬Ѱ����Сֵ��������ֵС�����ֵ����������쳣ֵ��λ�ã�һֱ������߳����������������
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
