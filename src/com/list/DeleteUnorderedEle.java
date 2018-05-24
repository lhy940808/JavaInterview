package com.list;

import java.util.HashSet;

public class DeleteUnorderedEle {

	public static void main(String[] args) {
		int[] arr = {1,2,4,2,1,3,4,1,2,1};
		
		DeleteUnorderedEle due = new DeleteUnorderedEle();
		Node node = new Node();
		Node head = node.create(arr);
		System.out.println("create list --------");
		node.print(head);
//		due.delete(head);
		due.delete2(head);
		System.out.println("\ndelete list repeated elements ---");
		node.print(head);
		
	}
	
//	ɾ�����������е��ظ�Ԫ��  ʱ�临�Ӷ�O(N)  �ռ临�Ӷ�O(N)
	public void delete(Node head) {
		if(head == null) {
			return;
		}
		Node cur = head.next;
		Node pre = head;
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(head.value);
		
		while(cur != null) {
			if(set.contains(cur.value)){
				pre.next = cur.next;
			}else {
				pre = cur;
				set.add(cur.value);
			}
			cur = cur.next;
		}
	}
	
	/*
	 * �ı�����ɾ��������ʹ�ÿռ临�Ӷȱ�Ϊo(1),
	    ������ʱ�任�ռ��˼��������ɾ��
	    ���˼�룺ÿ������һ��Ԫ�أ����Ӹ�Ԫ�ؿ�ʼ���������ɾ����Ԫ�ص��ظ�Ԫ��
	*/
	public void delete2(Node head) {
		if(head == null) {
			return;
		}
		
		Node cur = head;
		Node pre = null;
		while(cur!=null) {
			Node post = cur.next;
			pre = cur;
			while(post != null) {
				if(post.value == cur.value){
					pre.next = post.next;
				}else {
					pre = post;
				}
				post = post.next;
				
			}
			cur = cur.next;
		}
	}
	
	
}

class Node {
	public int value;
	public Node next;
	
	public Node (int value) {
		this.value = value;
	}
	
	public Node() {
		
	}
	public Node create(int[] arr) {
		if(arr == null || arr.length == 0) {
			return null;
		}
		
		//β�巨
		Node head = new Node(arr[0]);
		Node r = head;
		for(int i = 1; i < arr.length; i++) {
			Node cur = new Node(arr[i]);
			r.next = cur;
			r = cur;
		}
		
		r.next = null;
		return head;
	}
	
	public void print(Node head) {
		Node cur = head;
		while(cur != null) {
			System.out.print(cur.value + "  ");
			cur = cur.next;
		}
	}
}
