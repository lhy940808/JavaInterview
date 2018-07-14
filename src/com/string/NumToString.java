package com.string;

import java.util.TreeSet;

//问题：按照如下规则把数字翻译成字符串：0对应a， 1对应b 2对应c 3对应d......25 翻译成"z",一个数字可能有多个
//翻译，如12256 有五个，bccfi bwfi bczi mcfi mzi，请编程一个函数计算一个数字有多少中翻译方法
public class NumToString {
	
	private int index;
	TreeSet<String> set;
	StringBuffer sb;
	
	public static void main(String[] args) {
		int num = 12258;
		System.out.println("number to string total translate class is : " + new NumToString().count(num));
	}
	
	public int count(int num) {
		if (num < 0) {
			return -1;
		}
		
		this.index = 0;
		String str = String.valueOf(num);
	    char[] chr = str.toCharArray();
	    this.set = new TreeSet<String>();
	    this.sb = new StringBuffer();
	    countStr(chr);
	    for(String s : set) {
	    	System.out.print(s + "\t");
	    }
	    return set.size();
	    
	}
	
	public void countStr(char[] chr) {
		//因为只有0-25位的结果可以翻译，超出的就不行了
		//这里采用的递归思想分为第一位和剩余的部分
		
		if (index >= chr.length) {
			set.add(new String(sb));
			return;
		}
		
		sb.append(translate(chr, index, index));
		index++;
		countStr(chr);
		index--;
		sb.deleteCharAt(sb.length() - 1);
		
		//然后将index的后两个也包含进来

		if ((index  >= chr.length -1) ||  isValid(chr, index)) {
			return;
		}else {
			sb.append(translate(chr, index, index + 1));
			index += 2;
			countStr(chr);
			sb.deleteCharAt(sb.length() - 1);
			index -= 2;
		}
		
	}
	
	public boolean isValid(char[] chr, int index) {
		return (String.valueOf(chr[index]) + String.valueOf(chr[index + 1])).compareTo("26") > 0;
	}
	
	public String translate(char[] chr, int begin, int end) {
		String newStr = null;
		if (begin == end) {
			newStr = String.valueOf(chr[begin]);
		}else {
			newStr = String.valueOf(chr[begin]) + String.valueOf(chr[end]);
		}
		int num = Integer.parseInt(newStr);
		char res = (char) (num + 97);
		return String.valueOf(res);
		
	}

}
