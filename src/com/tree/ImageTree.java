package com.tree;

//问题：给定一个树，求这个树的镜像
public class ImageTree {

	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		BinaryTree root = UtilsTree.create(arr);
		new ImageTree().imageTree(root);
		UtilsTree.preOrderPrint(root);
	}
	
	public void imageTree(BinaryTree root) {
		if (root == null) {
			return;
		}
		if (root.leftChild == null && root.rightChild == null) {
			return;          
		}
		BinaryTree temp = root.leftChild;
		root.leftChild = root.rightChild;
		root.rightChild = temp;
		imageTree(root.leftChild);
		imageTree(root.rightChild);
	}
}
