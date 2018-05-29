package com.string;

//���⣺�ж�һ���ַ����Ƿ��ʾ��ֵ������������С��

//�磺+100 5e3 ��

public class NumberString {

	public static void main(String[] args) {
		String str = "12e-4";
		char[] chr = str.toCharArray();
		System.out.println("result is : " + new NumberString().isNumberic(chr));
	}
	public static boolean isNumberic (char[] chr) {
		if(chr == null) {
			return false;
		}
		
		int index = 0;
		int eCount = 0; //e����E�ĸ���
		int point = 0;//С����ĸ���
		//��ʼ��������
		if(chr[0] == '+' || chr[0] == '-') {
			index++;
		}
		
		for (int i = index; i < chr.length; i++) {
			
			if(chr[i] == '+' || chr[i] == '-') {
				if(chr[i - 1] != 'e' && chr[i - 1] != 'E'){
					return false;
				} 
				continue;
			}
			
			if(chr[i] == 'e' || chr[i] == 'E') {
				eCount++;
				if(eCount > 1) {
					return false;
				}
				if(i == 0 || chr[i - 1] < 48 || chr[i - 1] > 57 || i == chr.length - 1) {
					return false;
				}
				point++;
				continue;
			}
			
			if(chr[i] == '.') {
				point++;
				if(point > 1) {
					return false;
				}
				continue;
			}
			if((chr[i] < 48 || chr[i] > 57) && chr[i] != 'e' && chr[i] != 'E') {
				return false;
			}
		}
		return true;
	}

	
}
