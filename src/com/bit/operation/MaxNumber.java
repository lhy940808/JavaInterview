package com.bit.operation;

//问题：不用任何比较判断找出两个数中的较大的数
public class MaxNumber {

	public static void main(String[] args) {
		int a = 10;
		int b = 19;
		System.out.println(a + " and " + b + " max is : " + new MaxNumber().max(a, b));
	}
	
	public int max(int a, int b) {
		int c = a - b;
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		
		//表示a和b是否是相同符号的
		int difSab = sa ^ sb;
		
		int sameSab = flip(difSab);
		
		int returnA = difSab * sa + sameSab * sc;
		int returnB = flip(returnA);
		
		return a * returnA + b * returnB;
	} 
	
	public int flip(int n) {
		return n ^ 1;
	}
	//获取一个数的符号位 1 表示0和正数 0 表示负数
	public int sign(int n) {
		return flip((n >> 31) & 1);
	}
	
}
