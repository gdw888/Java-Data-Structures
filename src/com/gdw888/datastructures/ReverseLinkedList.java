package com.gdw888.datastructures;

public class ReverseLinkedList {

	// 1,2,3,4,5
	// 5,4,3,2,1
	
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String args[]) {
		ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
		reverseLinkedList.init();
	}
	
	public void init()
	{
		ListNode head = new ListNode(0);
		ListNode curNode = head;
		
		for (int i=1; i <= 10; i++) {
			curNode.next = new ListNode(i);
			curNode = curNode.next;
		}
		
		ListNode newHead = reverse(head);
		curNode = newHead;
		
		while (curNode != null) {
			System.out.print(curNode.val+" ");
			curNode = curNode.next;
		}
	}
	
	public ListNode reverse(ListNode head) {
		if (head.next == null)
			return head;

		ListNode curNode = head;
		ListNode nextNode = head.next;
		ListNode preNode = curNode;
		preNode.next = null;

		
		while (nextNode != null) {
			curNode = nextNode;
			nextNode = nextNode.next;
			curNode.next = preNode;
			preNode = curNode;
		}
		
		return curNode;
	}
}
