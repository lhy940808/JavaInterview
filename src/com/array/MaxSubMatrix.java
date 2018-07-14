package com.array;
//����һ������������ۼӺ͵��Ӿ���
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
		
		//˼�룺�����������ۼӺ�ת������������ۼӺ�
		//���Էֱ���ֻ��һ�� ���� ����Ԫ�ص��ۼӺͣ�Ȼ������������ۼӵ������������ۼӺ�����
		int[] sum = new int[matrix[0].length];
		int max = Integer.MIN_VALUE;
		//�ӵ�һ�п�ʼ
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
