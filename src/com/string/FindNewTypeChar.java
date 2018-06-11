package com.string;

/*	问题：新类型定义如下：
	1 新类型字符长度为1或者2
	2 表现形式可以仅是小写字母，也可以是大写字母+小写字母，也可以是大写字母+大写字母
*/

public class FindNewTypeChar {
	public static void main(String[] args) {
		String str = "aaABCDEcBCg";
		System.out.println("result is : " + new FindNewTypeChar().typeChar(str, 4));
	}
	
	public String typeChar(String str, int k) {
		if(str == null || str.length() == 0 || k < 0 || k >= str.length()) {
			return null;
		}
		//用来统计位置i之前的大写字母个数      
		int nNum = 0;
		
		char[] chr = str.toCharArray();
		
		for(int i = k - 1; i > -1; i--) {
			if(isSupper(chr[i])) {
				nNum++;
			}else {
				break;
			}
		}
		StringBuffer newStr = new StringBuffer();
		if (nNum % 2 != 0) {
			newStr.append(chr[k - 1]).append(chr[k]);
		}else if (isSupper(chr[k - 1])) {
			newStr.append(chr[k]).append(chr[k+1]);
		}else {
			newStr.append(chr[k]);
		}
		return newStr.toString();
	}

	private boolean isSupper(char c) {
		// TODO Auto-generated method stub
		if(c >= 'A' && c <= 'Z') {
			return true;
		}
		return false;
	}

}
