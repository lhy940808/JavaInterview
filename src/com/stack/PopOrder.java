package com.stack;

import java.util.Stack;



/*题目描述 
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1
 * 是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * */
public class PopOrder {

	public static void main(String[] args) {
		int[] push = {1,2,3,4,5};
		int[] pop1 = {4,5,3,2,1};
		int[] pop2 = {4,3,5,1,2};
		
		System.out.println("pop1 is poporder : " + isPopOrder(push, pop1));
		System.out.println("pop2 is poporder : " + isPopOrder(push, pop2));
		
	}
	
	public static boolean isPopOrder(int[] push, int[] pop) {
		if(push == null || pop == null || push.length != pop.length) {
			return false;
		}
		
		//生成一个辅助栈
		Stack<Integer> stack = new Stack<Integer>();
		
		int popIndex = 0;
		for(int i = 0; i < push.length; i++) {
			stack.push(push[i]);
			while(!stack.isEmpty() && stack.peek() == pop[popIndex]){
					stack.pop();
					popIndex++;
			}
		}
		return stack.empty();
	}
}
