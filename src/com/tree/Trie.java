package com.tree;

public class Trie {

	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word){
		if(word == null) {
			return;
		}
		
		char[] chs = word.toCharArray();
		TrieNode node = root;
		int index = 0;
		
		for(int i = 0; i < chs.length; i++) {
			index = chs[i] - 'a';
			if (node.map[index] == null) {
				node.map[index] = new TrieNode(); 
			}
			node = node.map[index];
			node.path++;
		}
		node.end++;
	}	
	
	public boolean search(String word) {
		if(word == null) {
			return false;
		}
		
		char[] chs = word.toCharArray();
		int index = 0;
		TrieNode node = root;
		for(int i = 0; i < chs.length; i++) {
			index = chs[i] - 'a';
			if(node.map[index] == null) {
				return false;
			}
			node = node.map[index];
		}
		return node.end == 0 ? false : true; 
	}
	
	public void delete(String word) {
		if(word == null) {
			return;
		}
		
		if(search(word)) {
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for(int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if(node.map[index].path-- == 1){
					node.map[index] = null;
					return;
				}
				node = node.map[index];
			}
			node.end--;
		}
	}
	
	//返回以pre字符串为前缀的单词数量
	public int prefixNumber(String pre) {
		if(pre == null) {
			return 0;
		}
		
		char[] chs = pre.toCharArray();
		TrieNode node = root;
		int index = 0;
		for(int i = 0; i < chs.length; i++) {
			index = chs[i] - 'a';
			if(node.map[index] == null) {
				return 0;
			}
			node = node.map[index];
		}
		return node.path;
	}
}
