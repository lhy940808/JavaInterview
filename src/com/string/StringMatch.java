package com.string;

/*
 * ���⣺�����ַ���str�����о��Բ�����.�� �� '*', �ٸ����ַ���exp�����п��Ժ��� '.', '*'
	'*'������exp�����ַ���������������'*'�ַ��������ڣ�exp�е�'.'�����κ�һ���ַ���'*'��ʾ'*'��ǰһ���ַ�������0�����߶����
	��дһ���������ж�str�Ƿ��ܱ�expƥ��
*/
public class StringMatch {
	
	
	public static void main(String[] args) {
		String str = "ab";
		String exp = "ab*";
		char[] strChar = str.toCharArray();
		char[] expChar = exp.toCharArray();
		
		StringMatch sm = new StringMatch();
		
		boolean vaild = sm.isVaild(strChar, expChar);
		
		System.out.println("is vaild : " + vaild);
		boolean match = false;
		if (vaild) {
			 match = sm.isMatch(strChar, expChar, 0, 0);
		}
		
		System.out.println("is match : " + match);
	}
	
//	���ȵ��ж�����������ַ����Ƿ�Ϸ�
	
	public boolean isVaild(char[] str, char[] exp) {
		if(str == null || exp == null) {
			return false;
		}
		for(int i = 0; i < str.length; i++) {
			if(str[i] == '.' || str[i] == '*') {
				return false;
			}
		}
		
//		�ж�exp�ĺϷ���
		for(int i = 0; i < exp.length; i++) {
//			if((i == 0 && exp[i] == '*' ) || (i != exp.length - 1 && (exp[i] == '*' && exp[i + 1] == '*')) ) {
//				return false;
//			}
			if(exp[i] == '*' && (i == 0 || exp[i - 1] == '*')) {
				return false;
			}
		}
		
		return true;
		
	}
	
//	�ж���Ϸ��ԣ��������ж�str��exp�Ƿ�ƥ��
	public boolean isMatch(char[] str, char[] exp, int si, int ei){
		if(ei == exp.length) {
			return si == str.length;
		}
		
//		���һ�����ei + 1 ��= '*', 
		if (ei + 1 == exp.length || exp[ei + 1] != '*' ) {
			return (si != str.length && (exp[ei] == str[si] || exp[ei] == '.')) && isMatch(str, exp, si + 1, ei + 1);
		}
		
//		�������ei + 1 == '*'
		while(si != str.length && (str[si] == exp[ei] || exp[ei] == '.')) {
			if(isMatch(str, exp, si, ei + 2)) {
				return true;
			}
			si++;
		}
		return isMatch(str, exp, si, ei + 2);
	}
}
