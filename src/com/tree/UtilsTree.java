package com.tree;

import java.util.LinkedList;
import java.util.List;

public class UtilsTree {

//	��һ���������飬����һ����
	public static BinaryTree create(int[] arr) {
		if (arr == null) {
			return null;
		}


		int index = 0;
		//Ϊ��ȷ�����ɵĽڵ�Ψһ�ԣ�������ÿһ���ڵ�洢��һ��������
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
		//������鳤��Ϊ���������Һ���
		if(arr.length % 2 == 1) {
			lastParentNode.rightChild = (BinaryTree) list.get(2 * lastParentIndex + 2);
		}
		return (BinaryTree) list.get(0);
	}
	
	//��ӡ������
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
