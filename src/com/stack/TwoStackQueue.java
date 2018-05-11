package com.stack;

import java.util.Stack;

//用两个栈实现一个队列
public class TwoStackQueue {

	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;
	
	public TwoStackQueue() {
		stackPush = new Stack<Integer>();
		stackPop = new Stack<Integer>();
	}
	
	public void add(int pushElement) {
		stackPush.push(pushElement);
	}
	
//	获取并移除队列的头
	public int poil() {
		if(stackPop.empty() && stackPush.empty()){
			throw new RuntimeException("Queue is empty !");
		}else if(stackPop.empty()){
			while(!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	
//	获取但不移除队列的头
	public int peek() {
		if(stackPop.empty() && stackPush.empty()){
			throw new RuntimeException("Queue is empty !");
		}else if(stackPop.empty()) {
			while(!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
	
}
