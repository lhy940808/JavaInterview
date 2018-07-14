package com.list;

//问题： 复杂链表的复制，与一般链表不不同的是，这个链表的一个节点可能指向其他任意节点
public class ComplexListCopy {

	public static void main(String[] args) {
		
	}
	
	public ComplexListNode clone(ComplexListNode head) {
		//第一步：在原链表上将每个节点都复制一个
		cloneNodes(head);
		//第二步，将复制的节点的任意节点指向复制
		cloneSiblingNodes(head);
		//第三步：将上述构成的链表分成两个部分
		return reconnectNodes(head);
	}
	
	public void cloneNodes(ComplexListNode head) {
		ComplexListNode node = head;
		while (node != null) {
			ComplexListNode next = node.next;
			ComplexListNode copy = new ComplexListNode();
			copy.value = node.value;
			node.next = copy;
			copy.next = next;
			node = next;
		}
	}
	
	public void cloneSiblingNodes(ComplexListNode head) {
		ComplexListNode node = head;
		while (node != null) {
			ComplexListNode copy = node.next;
			if (node.pSibling != null) {
				copy.pSibling = node.pSibling.next;
			}
			node = copy.next;
		}
	}
	
	public ComplexListNode reconnectNodes(ComplexListNode head) {
		if (head == null) {
			return null;
		}
		ComplexListNode cloneHead = head.next;
		ComplexListNode cloneNode = head.next;
		ComplexListNode node = head;
		node.next = cloneNode.next;
		node = node.next;
		while (node != null) {
			cloneNode.next = node.next;
			cloneNode = cloneNode.next;
			node.next = cloneNode.next;
			node = node.next;
			
			
			
		}
		return cloneHead;
	}
	
}


class ComplexListNode {
	public int value;
	public ComplexListNode next;
	public ComplexListNode pSibling;
	
}
