package com.stack;

import java.util.Stack;

//������ջʵ��һ������
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
	
//	��ȡ���Ƴ����е�ͷ
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
	
//	��ȡ�����Ƴ����е�ͷ
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
