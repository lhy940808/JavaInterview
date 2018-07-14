package com.list;

//���⣺ ��������ĸ��ƣ���һ��������ͬ���ǣ���������һ���ڵ����ָ����������ڵ�
public class ComplexListCopy {

	public static void main(String[] args) {
		
	}
	
	public ComplexListNode clone(ComplexListNode head) {
		//��һ������ԭ�����Ͻ�ÿ���ڵ㶼����һ��
		cloneNodes(head);
		//�ڶ����������ƵĽڵ������ڵ�ָ����
		cloneSiblingNodes(head);
		//�����������������ɵ�����ֳ���������
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
