package com.algorithm;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("fibonacci result is : " + new Fibonacci().fibonacci(20));
		System.out.println("fibonacci reuslt by loop : " + new Fibonacci().fibonacciByLoop(20));
	}
	public int fibonacci(int n ) {
		if(n == 0) {
			return 0;
		}
		if( n == 1 ){
			return 1;
		}
		return fibonacci(n -1) + fibonacci(n - 2);
	}
	
	public int fibonacciByLoop(int n) {
		int[] result = {0,1};
		if(n < 2) {
			return result[n];
		}
		
		int fibNMinusOne = 1;
		int fibNMinusTwo = 0;
		int fibN = 0;
		for(int i = 2; i <= n; i++) {
			fibN = fibNMinusOne + fibNMinusTwo;
			
			fibNMinusTwo = fibNMinusOne;
			fibNMinusOne = fibN;
		}
		return fibN;
	}
}
