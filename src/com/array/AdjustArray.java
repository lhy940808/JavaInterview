package com.array;

//问题:调整数组，要么使奇数下标对应的都是奇数 要么湿偶数下标全是偶数

public class AdjustArray {

	public static void main(String[] args) {
		int[] arr = {1,8,3,2,4,6};
		new AdjustArray().adjust(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		int[] arr1 = {1,8,3,2,4,6};
		new AdjustArray().adjust2(arr1);
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}
	
	public void adjust(int[] arr) {
		if (arr == null || arr.length == 0 || arr.length < 2) {
			return;
		}
		
		//确定奇数坐标和偶数坐标的个数
		int oddNumber = (arr.length % 2  == 0) ? arr.length / 2 : arr.length / 2 - 1;
		int evenNuomber = (arr.length % 2 == 0) ? arr.length / 2 : arr.length / 2 + 1;
		
		int odd = 0;
		int even = 0;
		//统计数组中奇数和偶数的个数
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				even++;
			}else {
				odd++;
			}
		}
		boolean flag = false;//默认偶数
		//确定是将奇数下标对应奇数 还是将偶数下标对应偶数
		if (odd > oddNumber) {
			flag = true;
		}
		
		//flag 为false : 从偶数坐标开始 true 从奇数坐标开始
		int begin = 0;//开始坐标
		if (flag)
			begin = 1;
		int i = begin;
		while (i < arr.length) {
			//不符合条件，则交换
//			System.out.println("result " + (arr[i] % 2 == 0));
			if ((arr[i] % 2 == 0) == flag) {
				int j = flag == true ? 0 : 1;
				while (j < arr.length) {
					if ((arr[j] % 2 == 0) != flag) {
						swap(arr, j, i);
						break;
					}
					j += 2;
				}
			}else {
				i += 2;
			}
		}
	}
	
	public void swap(int[] arr, int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	} 
	
	//书中方法：分别用两个变量指向最左边的偶数下标和奇数下标，然后和最后一个数交换，最后一个数是偶数就和偶数坐标交换，奇数就和奇数坐标交换
	public void adjust2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int even = 0;
		int odd = 1;
		int len = arr.length - 1;
		while (even < arr.length && odd < arr.length) {
			if(arr[len] % 2 == 0) {
				swap(arr, even, len);
				even += 2;
			}else {
				swap(arr, odd, len);
				odd += 2;
			}
		} 
	}
}
