package com.tree;

//字典树的结构
public class TrieNode {

	public int path;//表示有多少个单词共用这个节点
	public int end;//表示有多少个单词以这个节点结尾
	public TrieNode[] map;//key表示该节点的一条字符路径，value表示字符路径指向的节点
	
	
	
	public TrieNode() {
		path = 0;
		end = 0;
		map = new TrieNode[26];
	}
}
