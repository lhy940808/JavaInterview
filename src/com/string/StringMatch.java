package com.string;

/*
 * 问题：给定字符串str，其中绝对不含‘.’ 和 '*', 再给定字符串exp，其中可以含有 '.', '*'
	'*'不能是exp的首字符，并且任意两个'*'字符不能相邻，exp中的'.'代表任何一个字符，'*'表示'*'的前一个字符可以有0个或者多个。
	请写一个函数，判断str是否能被exp匹配
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
	
//	首先得判断两个输入的字符串是否合法
	
	public boolean isVaild(char[] str, char[] exp) {
		if(str == null || exp == null) {
			return false;
		}
		for(int i = 0; i < str.length; i++) {
			if(str[i] == '.' || str[i] == '*') {
				return false;
			}
		}
		
//		判断exp的合法性
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
	
//	判断完合法性，接下来判断str和exp是否匹配
	public boolean isMatch(char[] str, char[] exp, int si, int ei){
		if(ei == exp.length) {
			return si == str.length;
		}
		
//		情况一：如果ei + 1 ！= '*', 
		if (ei + 1 == exp.length || exp[ei + 1] != '*' ) {
			return (si != str.length && (exp[ei] == str[si] || exp[ei] == '.')) && isMatch(str, exp, si + 1, ei + 1);
		}
		
//		情况二：ei + 1 == '*'
		while(si != str.length && (str[si] == exp[ei] || exp[ei] == '.')) {
			if(isMatch(str, exp, si, ei + 2)) {
				return true;
			}
			si++;
		}
		return isMatch(str, exp, si, ei + 2);
	}
}
