package com.dynamic;

//有一段绳子，长度为n，把绳子剪成m段，求这m段绳子长度乘积最大的☞是多少

public class CutRope {

	public static void main(String[] args) {
		System.out.println("result is : " + new CutRope().maxProductAfterCutting(3));
	}
//	使用动态规划的方法进行处理
	public int maxProductAfterCutting(int length) {
		if(length < 0) {
			throw new RuntimeException("invaild parameter!!!");
		}
		if(length < 2) {
			return 0;
		}
		if(length == 2) {
			return 1;
		}
		if(length == 3) {
			return 2;
		}
		
		int[] products = new int[length + 1];
		
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;
		int max = 0;
		for(int i = 4; i <= length; i++) {
			max = 0;
			for(int j = 1; j <= i/2; j++) {
				int product = products[j] * products[i - j];
				if(max < product) {
					max = product;
				}
				products[i] = max;
			}
		}
		max = products[length];
		return max;
	}
	
//	使用贪婪算法来求绳子的最大乘积
	
}
