package com.array;

//一个数组中有奇数，偶数，要求将数组中的所有奇数调整到偶数前面
public class OddEven {
	
	public static void main(String[] args) {
		OddEven oe = new OddEven();
		int[] arr = {1,2,3,4,5,6,7,8};
		oe.reorderOddEven(arr);
		for(int i = 0; i < arr.length; i++)  {
			System.out.print(arr[i] + "  ");
		}
		
	}
	public void reorderOddEven(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		
		int left = 0;
		int right = arr.length - 1;
		
		while (left < right) {
			
//			第一个指针开始移动,直至遇到一个偶数
			while(arr[left] % 2 != 0 && left < right) {
				left++;
			}
			while(arr[right] % 2 == 0 && left < right) {
				right--;
			}
			if (left < right) {
				swap(arr, left, right);
			}
		}
	}

	private void swap(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
