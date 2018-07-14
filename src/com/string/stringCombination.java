package com.string;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

//问题：与全排列不同，这次求一个字符串的全组合，如abc的全组合为 a b c ab ac bc abc

public class stringCombination {
	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> list = new stringCombination().printCombination(str);
		System.out.println(list);
/*		for (String s : list) {
			System.out.println(s);
		}
*/	}
	private int index;
	private Set<String> set;
	private StringBuffer sb;
	
	public ArrayList<String> printCombination(String str) {
		if (str == null || str.trim().length() == 0) {
			return null;
		}
		char[] chr = str.toCharArray();
		set = new TreeSet<String>();
		index = 0;
		sb = new StringBuffer();
		//组合一共有1..chr.length 个长度的可能
	   //计算每个长度可能的结果
		for (int i = 1; i <= chr.length; i++) {
			printCore(chr, i);			
		}
		return new ArrayList<String>(set);
	}
	//第二个参数表示组合的长度
	private void printCore(char[] chr, int len) {
		// TODO Auto-generated method stub
		if (len == 0) {
			set.add(sb.toString());
			return;
		}
		
		//这个问题的关键是把字符串分成两部分 ：第一个字符和剩余的字符
		//如果剩余的字符长度不够len，那么就不用找了
		if (chr.length - index < len) {
			return;
		}
		
		//有两种可能：第一个字符包含在组合中，第一个字符不包含在组合中
		
		//第一种可能
		sb.append(chr[index]);
		++index;
		printCore(chr, len - 1);
		sb.deleteCharAt(sb.length() - 1);
		
		//第二种可能
		printCore(chr, len);
		--index;
		
	}
	
}
