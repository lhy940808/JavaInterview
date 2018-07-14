package com.bit;
//问题：给定一个整型数组，和一个大于1的整数k，已知数组中只有一个数出现了一次其他数都出现了k次，请返回这个数

public class OnceNum {

	public static void main(String[] args) {
		int[] arr = {7,3,3,2,2};
		int k = 2;
		System.out.println("once num is :" + new OnceNum().getNum(arr, k));
		System.out.println("-2 的补码是：" );
		int[] res = new OnceNum().getKSysNumFromNum(-2, 2);
		for(int e : res) {
			System.out.print(e + " ");
		}
	}
	
//	思想：k个k进制的数进行无进位相加得到的结果一定是0
//	（a[i] + b[i]）% k为每一位上的相加结果
	public int getNum(int[] arr, int k) {
		if (arr == null) {
			return -1;
		}
		
		//遍历数组，将数组转换为k进制数，并进行累加
		int[] e0 = new int[32];
		for(int i = 0; i < arr.length; i++) {
			setExclusiveOr(e0, arr[i], k);
		}
		
		int res = getNumFromSysNum(e0, k);
		return res;
	}
	
	public void setExclusiveOr(int[] e0, int value, int k) {
		//将整数转换成k进制
		int[] curKSysNum = getKSysNumFromNum(value, k);
		
//		和e0进行无进位相加
		for(int i = 0; i < e0.length; i++) {
			e0[i] = (e0[i] + curKSysNum[i]) % k;
		}
	}
	
	public int[] getKSysNumFromNum(int value, int k) {
		int[] res = new int[32];
		int index = 0;
		while (value != 0) {
			res[index++] = value % k;
			value /= k;
		}
		return res;
	}
	
	///将k进制数转换为10进制数
	public int getNumFromSysNum(int[] e0, int k) {
		int res = 0;
		for(int i = e0.length - 1; i >= 0; i--) {
			res = res * k + e0[i];
		}
		return res;
	}
}
