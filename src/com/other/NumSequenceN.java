package com.other;

//问题：数字以0123456789101112131415.。。。的格式序列化到一个字符序列中，在这个序列中，第五位（从0开始计数）时5，
//第13位时1，请写一个函数，求任意第n位对应的数字

public class NumSequenceN {

	public static void main(String[] args) {
		System.out.println("result is : " + new NumSequenceN().getNthNum(0));
		System.out.println("great method is : " + new NumSequenceN().digitAtIndex(1));
	}
	
	public int getNthNum(int n) {
		if (n < 0) {
			throw new RuntimeException("input invalid!!!");
		}
		
		int num = 9;
		int totalBits = 0;
		int kNum =0;
		int bits = 0;
		int total = 0;
		if (n < 10) {
			return n;
		}else {
			n -= 10;
		}
		for (int i = 2; i < Integer.MAX_VALUE; i++) {
			totalBits = (int) (num * Math.pow(10, i - 1) * i);
			
			if (n < totalBits) {
			    kNum = (int) (n / i + Math.pow(10, i - 1));
			    System.out.println(kNum);
				bits = n % i;
				total = i;
				break;
			}else {
				n -= totalBits;
			}
		}
		return getNumber(kNum, total, bits);
	}
	public int getNumber(int kNum, int total, int bits){
		int result = 0;
		for (int i = 0; i < total - bits; i++) {
			result = kNum % 10;
			kNum /= 10;
		}
		return result;
	}
	
	
	//将上述方法包装的更加优雅
	public int digitAtIndex (int index) {
		if (index < 0) 
			return -1;
		int digits = 1;
		while (true) {
			//获取有几位数的个数
			int numbers = countOfInteger(digits);
			if (index < numbers * digits) {
				return digitAtIndex(index, digits);
			}
			index -= digits * numbers;
			digits++;
		}
	}

	private int digitAtIndex(int index, int digits) {
		int result = 0;
		int num = beginNumber(digits) + index / digits;
	
		for (int i = 0; i < (digits - (index % digits)); i++) {
			result = num % 10;
			num /= 10;
		}
		return result;
	}

	private int beginNumber(int digits) {
		if (digits == 1) {
			return 0;
		}
		return (int) Math.pow(10, digits - 1);
	}

	private int countOfInteger(int digits) {
		// TODO Auto-generated method stub
		if (digits == 1) {
			return 10;
		}
		int count =(int)Math.pow(10, digits - 1);
		return 9 * count;
	}
}
