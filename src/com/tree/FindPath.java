package com.tree;

import java.util.ArrayList;

//���⣺����һ����������һ��������ӡ���������нڵ�ֵ�ĺ�Ϊ��������������·���������ĸ��ڵ�����һֱ��Ҷ�ӽڵ��������Ľڵ��γ�һ��·��
public class FindPath {
	
	public static void main(String[] args) {
		int[] arr = {10, 5, 12, 4, 7};
		BinaryTree root = UtilsTree.create(arr);
		UtilsTree.preOrderPrint(root);
		int target = 22;
		ArrayList<ArrayList<Integer>> pathList = findPath(root, target);
		
		
		for(ArrayList<Integer> list : pathList) {
			for(Integer path : list){
				System.out.print(path + "  ");
			}
			
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> findPath(BinaryTree root, int sum) {
		if (root == null) {
			return null;
		}
		
		ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
		int curSum = 0;
		ArrayList<Integer> curPath = new ArrayList<Integer>();
		
	    findPathCore(root, sum, curSum, pathList, curPath);
		return pathList;
	}
	
	public static void findPathCore(BinaryTree root, int sum, int curSum, ArrayList<ArrayList<Integer>> pathList, ArrayList<Integer> curPath) {
		if (root == null) {
			return;
		}
		
		curSum += root.value;
		boolean isLeaf = (root.leftChild == null && root.rightChild == null);
		if (isLeaf) {
			if (curSum == sum){
				curPath.add(root.value);
				pathList.add(new ArrayList<Integer>(curPath));
				//�Ƴ�Ҷ�ӽڵ�
				curPath.remove(curPath.size() - 1);
			}
			curSum -= root.value;
			return;
		}
		
		curPath.add(root.value);
		findPathCore(root.leftChild, sum, curSum, pathList, curPath);
		findPathCore(root.rightChild, sum, curSum, pathList, curPath);
		
		//���Ҫ������ڵ��˳�·��
		curPath.remove(curPath.size() - 1);
		
		
	}
	

}
