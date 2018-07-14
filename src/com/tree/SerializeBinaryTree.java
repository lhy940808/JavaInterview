package com.tree;

//���⣺ʵ�������������ֱ��������л��������ͷ����л�������
public class SerializeBinaryTree {
	private int index;
	public static void main(String[] args) {
		SerializeBinaryTree sbt = new SerializeBinaryTree();
		sbt.test1();
		sbt.test2();
		sbt.test3();
	}
	
	
	//���⣺���ǽ�һ�Ŷ��������ַ�����ʾ������Ϊ�գ������������ַ���ʾ
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
	
	//���⣺���ǽ�һ���ö�������ʾ���ַ������һ��������
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
	
	//����һ�����ܲ���
	/*  1
	   / \
      2   3
     /    /\
    4    5 6
    
    */
	
	public void test1() {
		//����һ����
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
		
		//���л�
		String str = serialize(root);
		System.out.println("serialize result is : " + str);
		
		//����������л�
		BinaryTree head = deserialize(str);
		System.out.println("result is : " + serialize(head));
	} 
	
	//���Զ����߽����
	
//	  1 ֻ��һ���ڵ�
//	  2 ֻ������ϵ�G��
//	  3 ֻ�����ӽڵ�
	
	public void test2() {
		BinaryTree root1 = deserialize("1,2,$,$,$,$");
		System.out.println("only leftchild serialize result is : " + serialize(root1));
		
		BinaryTree root2 = deserialize("1,$,3,$,$");
		System.out.println("only rightchild serialize result is : " + serialize(root2));
		
		BinaryTree root3 = deserialize("1,$,$");
		System.out.println("only root serialize result is : " + serialize(root3));
	}
	
	//������: ���˲��ԣ������ַ���Ϊ�գ�������Ϊ��
	public void test3() {
		BinaryTree root = deserialize("");
		System.out.println("null tree serialize is : " + serialize(root));
	}
	
}

