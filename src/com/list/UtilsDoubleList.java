package com.list;
        
public class UtilsDoubleList {

	public static DoubleList create(int[] arr) {
		if (arr == null) {
			return null;
		}
		DoubleList head = new DoubleList(arr[0]);
		DoubleList r = head;
		DoubleList pre = head;
		
		for (int i = 1; i < arr.length; i++) {
			DoubleList cur = new DoubleList(arr[i]);
			r.next = cur;
			cur.pre = r;
			r = cur;
		}
		r.next = null;
		return head;
	}
	
	public static void print(DoubleList head) {
		DoubleList node = head;
		while (node != null) {
			System.out.println("cur node is " + node.value + "  pre node is : " + (node.pre == null ? "null" : node.pre.value) + "  next value : " + (node.next == null ? "null" : node.next.value));
			node =node.next;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		DoubleList head = new UtilsDoubleList().create(arr);
		new UtilsDoubleList().print(head);
	}
}
