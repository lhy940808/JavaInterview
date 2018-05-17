package com.string;

//翻转字符串：给定一个字符类型的数组chas请在单词间做逆序调整，只要做到单词顺序逆序即可，对空格的位置没有特别要求

//如 dog loves pig => pig loves dog    I'm a student. => student. a I'm

public class TurnString {
	
	public String turn(char[] chas) {
		if(chas == null || chas.length == 0) {
			return "";
		}
		
		// 1 首先将字符串逆序
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
