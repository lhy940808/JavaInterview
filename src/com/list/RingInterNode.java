package com.list;

//求链表中环的入口节点
public class RingInterNode {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		Node head = Node.create(arr);
		Node loopNode = getNodeOfLoop(head);
		if(loopNode != null) {
			System.out.println("loop node is : " + loopNode.value);
		}else {
			System.out.println("no loop ");
		}
		
	}
	
	//首先判断链表是否有环，如果有，则找出环中的节点，以此可以算出环的大小
	public static Node meetingNode(Node head) {
		if(head == null) {
			return null;
		}
		
		Node pSlow = head;
		Node pFast = head.next;
		while(pSlow != null && pFast != null) {
			if (pSlow == pFast) {
				return pSlow;
			}
			pSlow = pSlow.next;
			pFast = pFast.next;
			if(pFast != null) {
				pFast = pFast.next;
			}
		}
		return null;
	}
	
	//计算环的入口节点
	public static Node getNodeOfLoop(Node head) {
		if(head == null) {
			return null;
		}
		
		//获得环中的节点
		Node mNode = meetingNode(head);
		if(mNode == null) {
			return null;
		}
		
		//计算环的大小
		Node pBegin = mNode;
		int count = 1; 
		while(pBegin.next != mNode) {
			count++;
			pBegin = pBegin.next;
		}
		
		//然后也是两个指针，一个先走count步，然后同时走，相遇的节点就是环的入口节点
		
		Node fast = head;
		Node slow = head;
		while(count-- > 0) {
			fast = fast.next;
		}
		while(true) {
			if(fast == slow) {
				break;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}
