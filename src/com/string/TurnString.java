package com.string;

//��ת�ַ���������һ���ַ����͵�����chas���ڵ��ʼ������������ֻҪ��������˳�����򼴿ɣ��Կո��λ��û���ر�Ҫ��

//�� dog loves pig => pig loves dog    I'm a student. => student. a I'm

public class TurnString {
	
	public String turn(char[] chas) {
		if(chas == null || chas.length == 0) {
			return "";
		}
		
		// 1 ���Ƚ��ַ�������
		char[] reverseStr = reverse(chas, 0, chas.length - 1);
		int start = 0;
		int end = 0;
		boolean isSpace = false;
		boolean isCount = false;
		for(int i = 0; i < chas.length; i++) {
			if(chas[i] != ' ' && !isSpace) {
				flag = true;
				start = i; 
			}
			if(chas[i] && cha)
		}
		
	}

	private char[] reverse(char[] chas, int start, int end) {
		// TODO Auto-generated method stub
	
		return null;
	}
}
