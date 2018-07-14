package com.string;

import java.util.ArrayList;
//����һ���ַ�������ӡ���ַ������ַ�������ȫ����
import java.util.TreeSet;

public class StringFullArray {

	public static void main(String[] args) {
		String str = "abca";
		new StringFullArray().printFullArray(str);
		ArrayList<String> list = new StringFullArray().printFullArray2(str);
		for (String str1 : list) {
			System.out.println(str1);
		}
	} 
	
	public void printFullArray(String str) {
		if (str == null || str.equals("")) {
			return;
		}
		
		ArrayList<Character> arrayPath = new ArrayList<Character>();
		char[] chr = str.toCharArray();
		boolean[] visited = new boolean[chr.length];
		printCore(chr, arrayPath, 0, visited);
	}
	
	public void printCore(char[] chr, ArrayList<Character> arrayPath, int len, boolean[] visited) {
		if (len >= chr.length ) {
			printList(arrayPath);
			
			return;
		}
		for ( int i = 0; i < chr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arrayPath.add(chr[i]);
				printCore(chr, arrayPath, len + 1, visited);
				visited[i] = false;
				arrayPath.remove(arrayPath.size() - 1);
			}
		}
		
	}
	
	public void printList(ArrayList<Character> list) {
		for (Character ele : list) {
			System.out.print(ele + "  ");
		}
		System.out.println();
	}
	
	private TreeSet<String> set;
	//�����������з�����ʹ�õݹ飬������ֽ�Ϊ�ַ�����Ϊ��һ���ַ���ʣ����ַ�
	public ArrayList<String>  printFullArray2(String str) {
		if (str == null || str.trim().equals("")) {
			return null;
		}
		
		//ʹ��treeset��Ϊ�˱�֤�ظ��ַ������Լ������ֵ�˳������
		char[] chr = str.toCharArray();
		set = new TreeSet<String>();
		printCore(chr, 0);
		return new ArrayList<String>(set);
	}
	public void printCore(char[] chr, int index) {
		if (index == chr.length - 1) {
			set.add(new String(chr));
			return;
		}
		for (int i = index; i < chr.length; i++) {
			swap(chr, i, index);
			printCore(chr, index + 1);
			swap(chr, i, index);
		}
	}
	
	public void swap(char[] chr, int i, int j) {
		char temp = chr[i];
		chr[i] = chr[j];
		chr[j] = temp;
	}
}
