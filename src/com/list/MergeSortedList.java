package com.list;

//问题：合并两个有序的链表
public class MergeSortedList {

	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7};
		int[] arr2 = {2,4,6};
		Node node = new Node();
		Node head1 = node.create(arr1);
		Node head2 = node.create(arr2);
		Node newHead = new MergeSortedList().merge(head1, head2);
		node.print(newHead);
		node.print(head1);
		System.out.println("----");
		node.print(head2);
//		Node newHead2 = new MergeSortedList().mergeByRecursion(head1, head2);
//		node.print(newHead2);
	}
	
	public Node merge(Node head1, Node head2) {
		if(head1 == null) {
			return head1;
		}
		if(head2 == null) {
			return head2;
		}
		
		Node cur1 = head1;
		Node cur2 = head2;
		Node newHead = cur1.value < cur2.value ? cur1 : cur2;
		if(cur1.value > cur2.value) {
			cur2 = cur2.next;
		}else {
			cur1 = cur1.next;
		}
		Node r = newHead;
		while(cur1 != null && cur2 != null) {
			if(cur1.value < cur2.value) {
				r.next = cur1;
				r = cur1;
				cur1 = cur1.next;
			}else {
				r.next = cur2;
				r = cur2;
				cur2 = cur2.next;
			}
		}
		while(cur1 != null) {
			r.next = cur1;
			r = cur1;
			cur1 = cur1.next;
		}
		while(cur2 != null) {
			r.next = cur2;
			r = cur2;
			cur2 = cur2.next;
		}
		
		r.next = null;
		return newHead;
	}
	
//	方法二：用递归的方式解决
	public Node mergeByRecursion(Node head1, Node head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		Node newHead = null;
		if (head1.value < head2.value) {
			newHead = head1;
			newHead.next = mergeByRecursion(head1.next, head2);
		}else {
			newHead = head2;
			newHead.next = mergeByRecursion(head1, head2.next);
		}
		return newHead;
	}
}
