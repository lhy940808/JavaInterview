package com.stack;

import java.util.Stack;

//问题：如何使得栈能够获取到最小值，并且时间复杂度为O(1)
public class MinStack {

	public static Stack<Integer> dataStack = new Stack<Integer>();
	public static Stack<Integer> minStack = new Stack<Integer>();
	
	public static void main(String[] args) {
		int[] arr = {3,8,4,2,5,1,9};
		
		//先将数组入栈
		for(int i = 0; i < arr.length; i++) {
			push(arr[i]);
		}
		//打印栈
//		print(dataStack);
		System.out.println("\t最小值111为： " + getMin());
		
		//弹出栈顶元素
		for(int i = 0; i < arr.length; i++) {
			pop();
//			print(dataStack);
			System.out.println("\t最小值为：" + getMin());
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
