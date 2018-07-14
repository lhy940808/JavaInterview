package com.stack;

import java.util.Stack;



/*��Ŀ���� 
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1
 * �Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
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
		
		//����һ������ջ
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
