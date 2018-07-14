package com.tree;

//问题： 根据输入的后序遍历的序列，判断这个序列是否是某个二叉搜索树的后序遍历

//思想：后序遍历序列的特点是最后一个节点是根节点
public class AdjusBinarySortedTree {

	public static void main(String[] args) {
		int[] arr = {5,7,6,9,11,10,3,8};
		System.out.println("array is binary sort tree : " + new AdjusBinarySortedTree().verifySequence(arr, 0, arr.length ));
		
	}
	
	public boolean verifySequence(int[] arr, int begin, int end) {
		if(arr == null || end < 0  || begin < 0 || end > arr.length || begin > arr.length){
			return false;
		}
		
		int root = arr[end - 1];
		
		//找到左右子树的分界线
		int line = 0;
		for(; line < end - 1; line++) {
			if(arr[line] > root) {
				break;
			}
		}
		int j = line;
		//从有子树开始搜索，有小于root的直接返回错误
		for(; j < end - 1; j++) {
			if(arr[j] < root) {
				return false;
			}
		}
		boolean left = true;
		if (line > 0) {
			left = verifySequence(arr, begin, line);
		}
		boolean right = true;
		if (j < end - 1) {
			right = verifySequence(arr, begin + line, end - 1);
		}
		return (left && right);
	}
}
