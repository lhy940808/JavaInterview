package com.search;


//��ת���飺��һ�������������ǰ������Ԫ��Ų�����棬��������Ϊ��ת����
//����Ҫ������������ת�����е���СԪ��
public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0,1,1,1};
		System.out.println("min value: " + new RotateArray().min(arr)); 
	}
	
	public int min(int[] array) {
		if(array == null || array.length == 0) {
			throw new RuntimeException("array is null");
		}
		int left = 0;
		int right = array.length - 1;
		int mid = left;
		while(array[left] >= array[right]) {
			if(right - left == 1) {
				mid = right;
				break;
			}
			mid = (left + right) / 2;
			if(array[left] == array[right] && array[mid] == array[right]) {
				return minInOrder(array, left, right);
			}
			if (array[mid] >= array[left]) {
				left = mid;
			}else if(array[mid] <=    array[right]) {
				right = mid;
			}
		}
		return array[mid];
	}

	private int minInOrder(int[] array, int index1, int index2) {
		// TODO Auto-generated method stub
		int result = array[index1];
		for(int i = index1 + 1; i <= index2; i++) {
			if(result > array[i]) {
				result = array[i];
			}
		}
		return result;
	}

}
