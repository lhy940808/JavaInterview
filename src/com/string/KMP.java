package com.string;

//利用kmp算法寻找一个字符串中的匹配另外一个字符串的初始出现的位置
public class KMP {

	public static void main(String[] args) {
		String str = "stop the world word";
		String match = "the";
		System.out.println("mathc index is : " + new KMP().getIndexOf(str, match));
	}
	public int getIndexOf(String str, String match) {
		if(str == null || match == null || str.length() < 1 || match.length() < 1 || str.length() < match.length()) {
			return - 1;
		}
		char[] s = str.toCharArray();
		char[] m = match.toCharArray();
		
		int si = 0;
		int mi = 0;
		int[] next = getNextArr(m);
		while(si < s.length && mi < m.length) {
			if (s[si] == m[mi]) {
				si++;
				mi++;
			}else if (next[mi] == -1) {
				si++;
			}else {
				mi = next[mi];
			}
		}
		return mi == m.length ? si - mi : -1;
	}

	private int[] getNextArr(char[] m) {
		// TODO Auto-generated method stub
		if(m.length == 1) {
			return new int[] {-1};
		}
		int[] next = new int[m.length];
		next[0] = -1;
		next[1] = 0;
		int cur = 2;
		int cn = 0;
		while(cur < m.length) {
			if(m[cur-1] == m[cn]) {
				next[cur++] = ++cn;
			}else if (cn > 0){
				cn = next[cn];
			}else {
				next[cur++] = 0;
			}
		}
		return next;
	}
}
