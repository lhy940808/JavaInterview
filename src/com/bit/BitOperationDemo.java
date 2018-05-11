package com.bit;

//给一个整数，求这个整数的二进制中有多少个1

public class BitOperationDemo {

//	方法1：普通做法，将整数每次都跟1做位与运算，然后将1左移，一直循环，直至n为0
//	public int NumberOf1(int n) {
//		int count  = 0;
//		int flag = 1;
//		while(flag > 1) {
//			if((n & flag) > 0) {
//				count++;
//			}
//		}
//		return 1;
//	}
	
	
	public int NumberOfOne(int n) {
		int count = 0;
		while(n != 0){
			n = n & (n - 1);
			count++;
		}
		return count;
	}
	

	public static void main(String[] args) {
		System.out.println("bit operation is : " + new BitOperationDemo().NumberOfOne(1024*1024));
	}
}
