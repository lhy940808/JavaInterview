package com.string;

//翻转字符串：给定一个字符类型的数组chas请在单词间做逆序调整，只要做到单词顺序逆序即可，对空格的位置没有特别要求

//如 dog loves pig => pig loves dog    I'm a student. => student. a I'm

public class TurnString {
	
	/*public boolean turn(char[] chas) {
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
//				flag = true;
				start = i; 
			}
//			if(chas[i] && cha)
		}
		return false;
		
	}*/
	

	public static void main(String[] args) {
		String str = "dog loves pig.";
		char[] chr = str.toCharArray();
		new TurnString().rotateWord(chr);
		System.out.println("result is : " + String.valueOf(chr));
		int size = 4;
		new TurnString().adjustString(chr, size);
		System.out.println("adjust result is : " + String.valueOf(chr));
		String str1 = "ABCDE1234";
		int len = 5;
		char[] chr1 = str1.toCharArray();
		new TurnString().adjustString2(chr1, len);
		System.out.println("adjust result (method 2) : " + String.valueOf(chr1));
	}
	
	
//	思想：先将字符串整体反转，然后再将每个单词逆序
	public void rotateWord(char[] chr) {
		if(chr == null || chr.length == 0) {
			return;
		}
		
//		首先将字符串逆序
		reverse(chr, 0, chr.length - 1);
		
//		然后将每个单词（也就是用空格隔开的字符串）逆序，这里的难点在于找出每个单词的开始和结束索引
		int start = -1;
		int end = -1;
		
		for(int i = 0; i < chr.length; i++) {
			if(chr[i] != ' ') {
				start = i == 0 || chr[i - 1] == ' ' ? i : start;
				end = i == chr.length - 1 || chr[i + 1] == ' ' ? i : end;
			}
			
			if(start != -1 && end != -1) {
				reverse(chr, start, end);
				start = 1;
				end = -1;
			}
		}
		
		
	}
	private void reverse(char[] chr, int start, int end) {
		// TODO Auto-generated method stub
		char temp = 0;
		while (start < end) {
			temp = chr[start];
			chr[start] = chr[end];
			chr[end] = temp;
			start++;
			end--;
		}
		
	}
	
	
//	变形题一:给定一个字符类型的数组chas和一个整数size，请把大小为size的左半区整体移到右半区，右半区整体移到左边
//	举例：ABCDE size = 3 变为： DEABC
	
//	解决方法一：先将整体逆序，然后左半部分（len -size） 和右边部分（size）分别逆序
//	举例：如ABCDE size = 3 ,整体逆序EDCBA ,左边逆序DECBA 右边逆序：DEABC
	
	public void adjustString(char[] chr, int size) {
		if(chr == null || chr.length == 0 || size <= 0 || size > chr.length) {
			return;
		}
		
//		1 首先将整体逆序
		reverse(chr, 0, chr.length - 1);
		
//		2 左边逆序
		reverse(chr, 0, chr.length - size - 1);
		
//		右边逆序
		reverse(chr, chr.length -size, chr.length - 1);
	}
	
	
//	以上是思路一，以下是思路二
	public void adjustString2(char[] chr, int size) {
		if(chr == null || chr.length == 0 || size <= 0 || size > chr.length) {
			return;
		}
		
		int lStart = 0;
		int rEnd = chr.length - 1;
		
		int lLen = size;
		int rLen = chr.length -size;
		int mLen = Math.min(lLen, rLen);
		
//		左右部分长度差
		int deta = lLen - rLen;
		while (true) {
//			交换左右部分内容
			exchange(chr, lStart, rEnd, mLen);
			
			if(deta == 0) {
				break;
			}else if(deta > 0) {
//				左边长度长
				lStart += mLen;
				lLen = deta;
			}else {
//				右边长度长
				rEnd -= mLen;
				rLen = -deta;
			}
			mLen = Math.min(lLen, rLen);
			deta = lLen - rLen;
		}
		
		
	}


	private void exchange(char[] chr, int lStart, int rEnd, int mLen) {
		// TODO Auto-generated method stub
		int rStart = rEnd - mLen + 1;
		while(mLen-- > 0) {
			char temp = chr[lStart];
			chr[lStart] = chr[rStart];
			chr[rStart] = temp;
			lStart++;
			rStart++;
		}
		
	}
}
