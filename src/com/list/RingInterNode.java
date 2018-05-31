package com.list;

//�������л�����ڽڵ�
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
	
	//�����ж������Ƿ��л�������У����ҳ����еĽڵ㣬�Դ˿���������Ĵ�С
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
	
	//���㻷����ڽڵ�
	public static Node getNodeOfLoop(Node head) {
		if(head == null) {
			return null;
		}
		
		//��û��еĽڵ�
		Node mNode = meetingNode(head);
		if(mNode == null) {
			return null;
		}
		
		//���㻷�Ĵ�С
		Node pBegin = mNode;
		int count = 1; 
		while(pBegin.next != mNode) {
			count++;
			pBegin = pBegin.next;
		}
		
		//Ȼ��Ҳ������ָ�룬һ������count����Ȼ��ͬʱ�ߣ������Ľڵ���ǻ�����ڽڵ�
		
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
