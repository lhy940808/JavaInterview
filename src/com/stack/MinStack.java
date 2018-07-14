package com.stack;

import java.util.Stack;

//���⣺���ʹ��ջ�ܹ���ȡ����Сֵ������ʱ�临�Ӷ�ΪO(1)
public class MinStack {

	public static Stack<Integer> dataStack = new Stack<Integer>();
	public static Stack<Integer> minStack = new Stack<Integer>();
	
	public static void main(String[] args) {
		int[] arr = {3,8,4,2,5,1,9};
		
		//�Ƚ�������ջ
		for(int i = 0; i < arr.length; i++) {
			push(arr[i]);
		}
		//��ӡջ
//		print(dataStack);
		System.out.println("\t��Сֵ111Ϊ�� " + getMin());
		
		//����ջ��Ԫ��
		for(int i = 0; i < arr.length; i++) {
			pop();
//			print(dataStack);
			System.out.println("\t��СֵΪ��" + getMin());
		}
		
	}
	
	public static void push(int number) {
		dataStack.push(number);
		if(minStack.isEmpty()){
			minStack.push(number);
		}else if (number < minStack.peek()){
			minStack.push(number);
		}
	}
	
	public static Integer pop() {
		if (dataStack.isEmpty()) {
			throw new RuntimeException("your stack is empty");
		}
		Integer data = dataStack.pop();
		if(data == minStack.peek()) {
			minStack.pop();
		}
		return data;
	}
	
	public static Integer getMin() {
		if(minStack.isEmpty()) {
			throw new RuntimeException("your stack is empty !!!");
		}
		return minStack.peek();
		
	}
	
//	public static void print()
	
	
}
