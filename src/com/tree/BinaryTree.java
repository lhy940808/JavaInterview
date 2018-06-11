package com.tree;

public class BinaryTree {
	public int value;
	
	public BinaryTree leftChild;
	public BinaryTree rightChild;
	
	public BinaryTree (int value) {
		this.value = value;
	}
	
	public void setLeftChild(BinaryTree left) {
		this.leftChild = left;
	}
	
	public void setRightChild(BinaryTree right) {
		this.rightChild = right;
	}
	
}
