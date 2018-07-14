package com.array;
//给定一个矩阵，求最大累加和的子矩阵
public class MaxSubMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{-1, -1, -1},
				 		  {-1, 2, 2},
				 		  {-1, -1, -1}};
		
		System.out.println("sub matrix max sum is : " + new MaxSubMatrix().getMatrixMaxSum(matrix));
	}
	
	
	public int getMatrixMaxSum(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		
		//思想：将求矩阵最大累加和转换成求数组的累加和
		//可以分别求只有一行 两行 三行元素的累加和，然后将下面的行数累加到，变成数组的累加和问题
		int[] sum = new int[matrix[0].length];
		int max = Integer.MIN_VALUE;
		//从第一行开始
		for(int i = 0; i < matrix.length; i++) {
			int times = i + 1;
			for (int j = 0; j < matrix[0].length; j++) {
				sum[j] = matrix[i][j];
			} 
			max = Math.max(max, getArrayMaxSum(sum));
			while (times < (matrix.length)){
				for (int j = 0; j < matrix[0].length; j++) {
					sum[j] += matrix[times][j];
				} 
				max = Math.max(max, getArrayMaxSum(sum));
				
				times++;
			}
		}
		return max;
	}
	
	public int getArrayMaxSum(int[] arr) {
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for (int i = 0; i < arr.length; i++) {
			cur += arr[i];
			max = Math.max(max, cur);
			cur = cur < 0 ? 0 : cur;
		}
		return max;
	}
}
