package com.bit.operation;

//���⣺�����καȽ��ж��ҳ��������еĽϴ����
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
		
		//��ʾa��b�Ƿ�����ͬ���ŵ�
		int difSab = sa ^ sb;
		
		int sameSab = flip(difSab);
		
		int returnA = difSab * sa + sameSab * sc;
		int returnB = flip(returnA);
		
		return a * returnA + b * returnB;
	} 
	
	public int flip(int n) {
		return n ^ 1;
	}
	//��ȡһ�����ķ���λ 1 ��ʾ0������ 0 ��ʾ����
	public int sign(int n) {
		return flip((n >> 31) & 1);
	}
	
}
