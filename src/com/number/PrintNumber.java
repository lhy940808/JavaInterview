package com.number;

//��������n, ����˳���ӡ��1������nλʮ����������������3����ӡ��1��2��3һֱ��3λ����999
public class PrintNumber {
	
	public static void main(String[] args) {
		new PrintNumber().printNumber(2);
	}
//	�ݹ�ʵ��
	public void printNumber(int n){
		char[] chr = new char[n];
		for(int i = 0; i < 10; i++) {
			chr[0] = (char)(i + 48);
//			System.out.println(chr[0]);
			printNumberRecursion(chr, 0);
		}
	}

	private void printNumberRecursion(char[] chr, int index) {
		// TODO Auto-generated method stub
		if(index == chr.length - 1) {
			print(chr);
			return;
		}
		for( int i = 0; i < 10; i++){
			chr[index + 1] = (char)(48 + i);
			printNumberRecursion(chr, index + 1);
		}
	}

	private void print(char[] chr) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		boolean isBegining0 = true;
		for( int i = 0; i < chr.length; i++) {
			if(isBegining0 && chr[i] != '0'){
				isBegining0 = false;
			}
			if(!isBegining0) {
				int cur = chr[i] - '0';
				sum = sum * 10 + cur;
			}
		}
		System.out.println(sum);
	}
	
	

}
