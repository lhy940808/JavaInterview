package com.tree;

//�ֵ����Ľṹ
public class TrieNode {

	public int path;//��ʾ�ж��ٸ����ʹ�������ڵ�
	public int end;//��ʾ�ж��ٸ�����������ڵ��β
	public TrieNode[] map;//key��ʾ�ýڵ��һ���ַ�·����value��ʾ�ַ�·��ָ��Ľڵ�
	
	
	
	public TrieNode() {
		path = 0;
		end = 0;
		map = new TrieNode[26];
	}
}
