package com.list;

import java.util.ArrayList;

import com.tree.BinaryTree;
import com.tree.UtilsTree;

//���⣺��һ�Ŷ���������ת����˫������
public class BSTToDoubleList {

	public BinaryTree lastNode;
	public static void main(String[] args) {
		int[] arr = {10,6,14,4,8,12,16};
		BinaryTree root = UtilsTree.create(arr);
		DoubleList head = new BSTToDoubleList().toDoubleList(root);
		UtilsDoubleList.print(head);
		BinaryTree newHead = new BSTToDoubleList().convert(root);
		
	}
	
	//�Լ����뷨��������������������������һ���ź�������У�Ȼ����������п�������һ��˫������
	
	public DoubleList toDoubleList(BinaryTree root) {
		if (root == null) {
			return null;
		}
		//�õ���������Ľ��
		int[] postOrder = getPostSequence(root);
		return UtilsDoubleList.create(postOrder);
	}
	
	public int[] getPostSequence(BinaryTree root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		postOrder(root, list);
		int[] result =new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}
	
	public void postOrder(BinaryTree root, ArrayList<Integer> list){
		if (root == null) {
			return;
		}
		postOrder(root.leftChild, list);
		list.add(root.value);
		postOrder(root.rightChild, list);
		
	}
	
	public BinaryTree convert(BinaryTree root) {
		if (root == null) {
			return null;
		}
		convertCore(root);
		BinaryTree pHead = lastNode;
		while (pHead != null && pHead.leftChild != null) {
			pHead = pHead.leftChild;
		}
		return pHead;
	}
	
	public void convertCore(BinaryTree root) {
		if (root == null) {
			return;
		} 
		
		convertCore(root.leftChild);
		root.leftChild = lastNode;
		if (lastNode != null) {
			lastNode.rightChild = root;
		}
		lastNode = root;
		convertCore(root.rightChild);
	}
	
}
