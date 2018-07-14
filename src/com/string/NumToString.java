package com.string;

import java.util.TreeSet;

//���⣺�������¹�������ַ�����ַ�����0��Ӧa�� 1��Ӧb 2��Ӧc 3��Ӧd......25 �����"z",һ�����ֿ����ж��
//���룬��12256 �������bccfi bwfi bczi mcfi mzi������һ����������һ�������ж����з��뷽��
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
		//��Ϊֻ��0-25λ�Ľ�����Է��룬�����ľͲ�����
		//������õĵݹ�˼���Ϊ��һλ��ʣ��Ĳ���
		
		if (index >= chr.length) {
			set.add(new String(sb));
			return;
		}
		
		sb.append(translate(chr, index, index));
		index++;
		countStr(chr);
		index--;
		sb.deleteCharAt(sb.length() - 1);
		
		//Ȼ��index�ĺ�����Ҳ��������

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
