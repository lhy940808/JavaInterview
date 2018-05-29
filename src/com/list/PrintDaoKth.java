package com.list;

import java.util.Scanner;

//#打印链表中倒数第k个节点
public class PrintDaoKth {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		Node head = Node.create(arr);
		Scanner in = new Scanner(System.in);
		System.out.print("请输入要打印倒数第几个节点");
		int k = in.nextInt();
		if(k <= 0 || k > Node.len(head)) {
			System.out.println("输入的节点数有误,请重新输入");
			return;
		}
		Node kNode = getDaoshuKth(head, k);
		Node kn = getDaoshuKth2(head, k);
		System.out.println("倒数第" + k + "节点是: " + kNode.value);
		System.out.println("倒数第" + k + "节点是 "  + kn.value);
	}

	private static Node getDaoshuKth(Node head, int k) {
		if(head == null || k == 0) {
			return null;
		}
		// TODO Auto-generated method stub
		int len = Node.len(head);
		int count = 0;
		Node cur = head;
		while(cur != null) {
			count++;
			cur = cur.next;
			if(count == (len - k)) {
				break;
			}
		}
		return cur;
	}
	
//	方法二:上述方法需要遍历两次链表,以下链表只需要遍历一次链表
	public static Node getDaoshuKth2(Node head, int k) {
		if(head == null || k == 0) {
			return null;
		}
		
//		1 声明两个指针,第一个指针先走k - 1步
		Node pHead = head;
		Node pBehind  = head;
		for(int i = 0; i < k - 1; i++) {
			if(pHead.next != null) {
				pHead = pHead.next;
			}else {
				return null;
			}
		}
		while(pHead.next != null) {
			pHead = pHead.next;
			pBehind = pBehind.next;
		}
		return pBehind;
	}
}
