package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


//问题：不分行从上到下打印一颗二叉树
public class PrintFromTopToBottom {

	public static void main(String[] args) {
		//创建一颗二叉树
		int[] arr = {1,2,3,4,5,6};
		BinaryTree root = UtilsTree.create(arr);
		
		int[] tree = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		BinaryTree root2 = UtilsTree.create(tree);
		
		print(root);
		System.out.println();
		println(root);
		System.out.println();
		printZhi(root);
		System.out.println("\n\n");
		printZhi(root2);
	}
	
	//从上到下打印二叉树, 不分行
	public static void print(BinaryTree root) {
		if (root == null) {
			return;
		}
		
		//生成一个队列
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		
		//将根节点入队列
		queue.add(root);
		
		while (!queue.isEmpty()) {
			BinaryTree node = queue.poll();
			System.out.print(node.value + ",");
			if(node.leftChild != null) {
				queue.add(node.leftChild);
			}
			if(node.rightChild != null) {
				queue.add(node.rightChild);
			}
		}
		
	}
	
	//从上到下打印 分行打印
	public static void println(BinaryTree root) {
		if (root == null) {
			return;
		}
		
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		
		queue.add(root);
		
		//用来记录当前层还有多少个节点需要被打印
		int toBePrinted = 1;
		
		//表示下一层有多少个节点需要打印
		int nextLevel = 0;
		
		while (!queue.isEmpty()) {
			BinaryTree node = queue.poll();
			System.out.print(node.value + "\t");
			toBePrinted--;
			
			if(node.leftChild != null) {
				queue.add(node.leftChild);
				nextLevel++;
			}
			
			if(node.rightChild != null) {
				queue.add(node.rightChild);
				nextLevel++;
			}
			
			if (toBePrinted == 0) {
				System.out.println();
				toBePrinted = nextLevel;
				nextLevel = 0;
			}
		}
	}
	
	//用之字形打印二叉树
	public static void printZhi(BinaryTree root) {
		if (root == null) {
			return;
		}
		
		//用两个栈分别表示奇数层和偶数层的节点
		Stack<BinaryTree> oddNode = new Stack<BinaryTree>();
		Stack<BinaryTree> evenNode = new Stack<BinaryTree>();
		
		oddNode.push(root);
		
		while (!oddNode.isEmpty() || !evenNode.isEmpty()) {
			while(!oddNode.isEmpty()) {
				BinaryTree node = oddNode.pop();
				System.out.print(node.value + "  ");
				if (oddNode.isEmpty()) {
					System.out.println();
				}
				if (node.leftChild != null) {
					evenNode.push(node.leftChild);
				}
				if (node.rightChild != null) {
					evenNode.push(node.rightChild);
				}
			}
			
			while (!evenNode.isEmpty()) {
				BinaryTree node = evenNode.pop();
				System.out.print(node.value + "  ");
				
				if (evenNode.isEmpty()) {
					System.out.println();
				}
				
				if (node.rightChild != null) {
					oddNode.push(node.rightChild);
				}
				
				if (node.leftChild != null) {
					oddNode.push(node.leftChild);
				}
			}
		}
		
	}
	
	
}
