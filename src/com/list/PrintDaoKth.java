package com.list;

import java.util.Scanner;

//#��ӡ�����е�����k���ڵ�
public class PrintDaoKth {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		Node head = Node.create(arr);
		Scanner in = new Scanner(System.in);
		System.out.print("������Ҫ��ӡ�����ڼ����ڵ�");
		int k = in.nextInt();
		if(k <= 0 || k > Node.len(head)) {
			System.out.println("����Ľڵ�������,����������");
			return;
		}
		Node kNode = getDaoshuKth(head, k);
		Node kn = getDaoshuKth2(head, k);
		System.out.println("������" + k + "�ڵ���: " + kNode.value);
		System.out.println("������" + k + "�ڵ��� "  + kn.value);
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
	
//	������:����������Ҫ������������,��������ֻ��Ҫ����һ������
	public static Node getDaoshuKth2(Node head, int k) {
		if(head == null || k == 0) {
			return null;
		}
		
//		1 ��������ָ��,��һ��ָ������k - 1��
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
