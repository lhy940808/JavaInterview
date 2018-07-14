package com.tree;

//���⣺ ��������ĺ�����������У��ж���������Ƿ���ĳ�������������ĺ������

//˼�룺����������е��ص������һ���ڵ��Ǹ��ڵ�
public class AdjusBinarySortedTree {

	public static void main(String[] args) {
		int[] arr = {5,7,6,9,11,10,3,8};
		System.out.println("array is binary sort tree : " + new AdjusBinarySortedTree().verifySequence(arr, 0, arr.length ));
		
	}
	
	public boolean verifySequence(int[] arr, int begin, int end) {
		if(arr == null || end < 0  || begin < 0 || end > arr.length || begin > arr.length){
			return false;
		}
		
		int root = arr[end - 1];
		
		//�ҵ����������ķֽ���
		int line = 0;
		for(; line < end - 1; line++) {
			if(arr[line] > root) {
				break;
			}
		}
		int j = line;
		//����������ʼ��������С��root��ֱ�ӷ��ش���
		for(; j < end - 1; j++) {
			if(arr[j] < root) {
				return false;
			}
		}
		boolean left = true;
		if (line > 0) {
			left = verifySequence(arr, begin, line);
		}
		boolean right = true;
		if (j < end - 1) {
			right = verifySequence(arr, begin + line, end - 1);
		}
		return (left && right);
	}
}
