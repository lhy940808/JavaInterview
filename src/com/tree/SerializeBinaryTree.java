package com.tree;

//问题：实现两个函数，分别用来序列化二叉树和发序列化二叉树
public class SerializeBinaryTree {
	private int index;
	public static void main(String[] args) {
		SerializeBinaryTree sbt = new SerializeBinaryTree();
		sbt.test1();
		sbt.test2();
		sbt.test3();
	}
	
	
	//问题：就是将一颗二叉树用字符串表示，孩子为空，可以用特殊字符表示
	public String serialize(BinaryTree root) {
		if (root == null) {
			return null;
		}
		
		StringBuffer sb = new StringBuffer();
		serializeCore(root, sb);
		return sb.toString();
		
	}
	
	public void serializeCore(BinaryTree root, StringBuffer sb) {
		if (root == null) {
			sb.append("$");
			return;
		}
		sb.append(root.value);
		serializeCore(root.leftChild, sb.append(','));
		serializeCore(root.rightChild, sb.append(','));
	}
	
	//问题：就是将一颗用二叉树表示的字符串变成一个二叉树
	public BinaryTree deserialize(String str) {
		if (str == null || str.trim().length() == 0) {
			return null;
		}
		String[] chr = str.split(",");
		index = 0;
		return deserialize(chr);
	}
	
	public BinaryTree deserialize(String[] chr) {
		if (chr[index].equals("$")) {
			index++;
			return null;
		}
		BinaryTree node = new BinaryTree(Integer.valueOf(chr[index++]));
		node.leftChild  = deserialize(chr);
		node.rightChild = deserialize(chr);
		return node;
	}
	
	//测试一：功能测试
	/*  1
	   / \
      2   3
     /    /\
    4    5 6
    
    */
	
	public void test1() {
		//生成一个树
		BinaryTree root = new BinaryTree(1);
		BinaryTree rLeft = new BinaryTree(2);
		BinaryTree rRight = new BinaryTree(3);
		BinaryTree node4 = new BinaryTree(4);
		BinaryTree node5 = new BinaryTree(5);
		BinaryTree node6 = new BinaryTree(6);
		root.leftChild = rLeft;
		root.rightChild = rRight;
		rLeft.leftChild = node4;
		rRight.leftChild = node5;
		rRight.rightChild = node6;
		
		//序列化
		String str = serialize(root);
		System.out.println("serialize result is : " + str);
		
		//将结果反序列化
		BinaryTree head = deserialize(str);
		System.out.println("result is : " + serialize(head));
	} 
	
	//测试二：边界测试
	
//	  1 只有一个节点
//	  2 只有左子系欸但
//	  3 只有右子节点
	
	public void test2() {
		BinaryTree root1 = deserialize("1,2,$,$,$,$");
		System.out.println("only leftchild serialize result is : " + serialize(root1));
		
		BinaryTree root2 = deserialize("1,$,3,$,$");
		System.out.println("only rightchild serialize result is : " + serialize(root2));
		
		BinaryTree root3 = deserialize("1,$,$");
		System.out.println("only root serialize result is : " + serialize(root3));
	}
	
	//测试三: 极端测试，输入字符串为空，二叉树为空
	public void test3() {
		BinaryTree root = deserialize("");
		System.out.println("null tree serialize is : " + serialize(root));
	}
	
}

