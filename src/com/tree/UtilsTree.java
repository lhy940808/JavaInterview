package com.tree;

import java.util.LinkedList;
import java.util.List;

public class UtilsTree {

//	给一个整数数组，创建一个树
	public static BinaryTree create(int[] arr) {
		if (arr == null) {
			return null;
		}


		int index = 0;
		//为了确保生成的节点唯一性，先生成每一个节点存储在一个链表中
		List list = new LinkedList<BinaryTree>();
		for(int i = 0; i < arr.length; i++) {
			list.add(new BinaryTree(arr[i]));
		}
		while (index < arr.length / 2 - 1) {
			BinaryTree parent = (BinaryTree) list.get(index);
			parent.leftChild = (BinaryTree) list.get(2 * index + 1);
			parent.rightChild = (BinaryTree) list.get(2 * index + 2);
			index++;
			
		}
		int lastParentIndex = arr.length / 2 - 1;
		BinaryTree lastParentNode = (BinaryTree) list.get(lastParentIndex);
		lastParentNode.leftChild = (BinaryTree) list.get(2 * lastParentIndex + 1);
		//如果数组长度为奇数才有右孩子
		if(arr.length % 2 == 1) {
			lastParentNode.rightChild = (BinaryTree) list.get(2 * lastParentIndex + 2);
		}
		return (BinaryTree) list.get(0);
	}
	
	//打印二叉树
	public static void preOrderPrint(BinaryTree root) {
		if(root != null) {
			System.out.print(root.value + "=>");
			preOrderPrint(root.leftChild);
			preOrderPrint(root.rightChild);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		BinaryTree root = UtilsTree.create(arr);
		preOrderPrint(root);
	}
}
