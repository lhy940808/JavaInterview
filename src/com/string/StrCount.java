package com.string;
//统计字符串中的个数 如：aaabb变为a_3b_2
public class StrCount {

	
	public static void main(String[] args) {
		String str = "aaaaaaaaaaabbadddffc";
		System.out.println("count string result is : " + new StrCount().count(str));
		String countStr = new StrCount().count(str);
		char charAt = new StrCount().getCharAt(countStr, 17);
		System.out.println("char at index is " + charAt);
	}
	public String count(String str) {
		if(str == null || str.length() == 0){
			return str;
		}
		StringBuffer newStr = new StringBuffer();
		char[] chr = str.toCharArray();
		char pre = chr[0];
		int count = 1;
		for(int i = 1; i < chr.length; i++) {
			if(chr[i] == pre) {
				count++;
			}else {
				newStr.append(pre).append('_').append(count).append('_');
				pre = chr[i];
				count = 1;
			}
		}
		newStr.append(pre).append('_').append(count);
		return newStr.toString();
	}
	
//	根据上面统计的字符串，给出一个数字，给出这个数字索引对应的字符
	
	public char getCharAt(String str, int index ) {
		if(str == null || str.length() == 0 || index < 0 || index >= str.length()) {
			return 0;
		}
		int count = 0;
		char[] chr = str.toCharArray();
		char pre = 0;
		int sum = 0;
		boolean stage = true;
		for(int i = 0; i < chr.length; i++) {
			int cur = chr[i] - '0';
			if(chr[i] != '_') {
				if(stage) {
					sum += count;
					if(sum >= index) {
						return pre;
					}
					pre = chr[i];
					count = 0;
				}else {
					count = count *10 + cur;
				}
			}else {
				stage = !stage;
				
			}
		}
		sum += count;
		return pre;
	}
}
