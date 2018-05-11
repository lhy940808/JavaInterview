package com.string;

import com.heap.HeapSort;

//判断一个字符串中的字符是否有重复字符
public class RepeatChar {

	public static void main(String[] args) {
		String str = "hu12ge1";
		System.out.println("result is ;" + RepeatChar.isUnique1(str));
		System.out.println("method 2 result :" + RepeatChar.isUnique2(str.toCharArray()));
	}
//	方法一：要求实现时间复杂度为O(N) 空间复杂度不要求
	public static boolean isUnique1(String str) {
		if(str == null || str.equals("")) {
			return true;
		}
		boolean[] map = new boolean[256];
		char[] chr = str.toCharArray();
		for(int i = 0; i < chr.length; i++) {
			if(map[chr[i]]) {
				return false;
			}
			map[chr[i]] = true;
		}
		return true;
	}
	
	public static boolean isUnique2(char[] chas) {
		if(chas == null) {
			return true;
		}
		new HeapSort().heapSort(chas);
		for(int i = 1; i < chas.length; i++) {
			if(chas[i -1 ] == chas[i]) {
				return false;
			}
		}
		return true;
	}
}
