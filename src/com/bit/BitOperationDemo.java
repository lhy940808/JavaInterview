package com.bit;

//��һ������������������Ķ��������ж��ٸ�1

public class BitOperationDemo {

//	����1����ͨ������������ÿ�ζ���1��λ�����㣬Ȼ��1���ƣ�һֱѭ����ֱ��nΪ0
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
