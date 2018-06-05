package com.string;

import java.util.Deque;
import java.util.LinkedList;

//问题：给定一个公式字符串，公式里可能有整数/加减乘除符号和左右括号，返回公式的计算结果
public class FromulaValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String exp = "48*((70-65)-43)+8*1";
		String exp = "-48*2";
		System.out.println(exp + "result is : " + new FromulaValue().getValue(exp));
	}
	
	public int getValue(String exp) {
		return value(exp.toCharArray(), 0)[0];
	}
	
	public int[] value(char[] chars, int i) {
		Deque<String> deq = new LinkedList<String>();
		
		int pre = 0;
		int[] bra = null;
		while (i < chars.length && chars[i] != ')') {
			if (chars[i] >= '0' && chars[i] <= '9') {
				pre = pre * 10 + chars[i++] - '0';
			}else if (chars[i] != '(') {
				addNum(deq, pre);
				deq.addLast(String.valueOf(chars[i++]));
				pre = 0;
			}else {
				bra = value(chars, i + 1);
				pre = bra[0];
				i = bra[1] + 1;
			}
		}
		addNum(deq, pre);
		return new int[]{getNum(deq), i};
		
	}
	
	public void addNum(Deque<String> deq, int num) {
		if(!deq.isEmpty()) {
			int cur = 0;
			String top = deq.pollLast();
			if (top.equals("+") || top.equals("-")) {
				deq.addLast(top);
			}else {
				cur = Integer.valueOf(deq.pollLast());
				num = top.equals("*") ? (cur * num) : (cur / num);
			}
		}
		
		deq.addLast(String.valueOf(num));
	}
	
	public int getNum(Deque<String> deq) {
		int res = 0;
		boolean add = true;
		String cur = null;
		int num = 0;
		while(!deq.isEmpty()) {
			cur = deq.pollFirst();
				if (cur.equals("+")) {
					add = true;
				}else if (cur.equals("-")){
					add = false;
				}else {
					num = Integer.valueOf(cur);
					res += add ? num : (-num);
				}
		}
		return res;
	}

}
