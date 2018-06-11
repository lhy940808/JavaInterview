package com.tree;

//问题：如果一棵树和它的镜像是一样的，则是对称的
public class SymmericalTree {
	
	public static void main(String[] args) {
		int[] tree = {8,6,6,5,7,7,5};
		
		BinaryTree root = UtilsTree.create(tree);
		
		System.out.println("tree is symmetrical : " + new SymmericalTree().isSymmetrical(root));
	}

	private boolean isSymmetrical(BinaryTree root) {
		// TODO Auto-generated method stub
		if(root == null) {
			return true;
		}
		return isCommon(root, root);
	}

	private boolean isCommon(BinaryTree root1, BinaryTree root2) {
		// TODO Auto-generated method stub
		if(root1 == null && root2 == null) {
			return true;
		}
		
		if(root1 == null || root2 == null) {
			return false;
		}
		
		if(root1.value != root2.value) {
			return false;
		}
		return isCommon(root1.leftChild, root2.rightChild)&&
				isCommon(root1.rightChild, root2.leftChild);
	}
	
}
