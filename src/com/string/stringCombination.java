package com.string;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

//���⣺��ȫ���в�ͬ�������һ���ַ�����ȫ��ϣ���abc��ȫ���Ϊ a b c ab ac bc abc

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
		//���һ����1..chr.length �����ȵĿ���
	   //����ÿ�����ȿ��ܵĽ��
		for (int i = 1; i <= chr.length; i++) {
			printCore(chr, i);			
		}
		return new ArrayList<String>(set);
	}
	//�ڶ���������ʾ��ϵĳ���
	private void printCore(char[] chr, int len) {
		// TODO Auto-generated method stub
		if (len == 0) {
			set.add(sb.toString());
			return;
		}
		
		//�������Ĺؼ��ǰ��ַ����ֳ������� ����һ���ַ���ʣ����ַ�
		//���ʣ����ַ����Ȳ���len����ô�Ͳ�������
		if (chr.length - index < len) {
			return;
		}
		
		//�����ֿ��ܣ���һ���ַ�����������У���һ���ַ��������������
		
		//��һ�ֿ���
		sb.append(chr[index]);
		++index;
		printCore(chr, len - 1);
		sb.deleteCharAt(sb.length() - 1);
		
		//�ڶ��ֿ���
		printCore(chr, len);
		--index;
		
	}
	
}
