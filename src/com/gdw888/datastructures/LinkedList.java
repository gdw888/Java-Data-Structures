package com.gdw888.datastructures;

public class LinkedList {
	
	Node head,tail;
	
	LinkedList(){
		head = null;
		tail = null;
	}
	
	public void addElement(int value) {
		if( head == null ){
			head = new Node(value);
			tail = head;
		}else {
			tail.nextNode = new Node(value);
			tail = tail.nextNode;
		}
	}
	
	public void removeElement(int value) {
		Node pre = null;
		Node cur = head;
		
		if (head == null)
			return;
		
		do {
			if (cur.getValue() == value) {
				
				if (pre == null) {
					head = cur.nextNode;
				}else {
					pre.nextNode = cur.nextNode;
				}

				if (tail == cur) {
					tail = cur.nextNode;
				}
				
				break;
			}
			
			pre = cur;
			cur = cur.nextNode;
		} while ( cur != null);
	}
	
	public void printList() {
		Node cur = head;
		
		System.out.println("Print linked list");
		
		while ( cur != null) {
			System.out.println(cur.getValue());
			cur = cur.nextNode;
		}
	}
	class Node{
		private int value;
		Node nextNode;
		
		Node(int value){
			this.value = value;
			this.nextNode = null;
		}
		
		public int getValue() {
			return value;
		}
		
		public void setValue(int value) {
			this.value = value;
		}
	}

	public static void main(String args[]) {
		LinkedList linkedList = new LinkedList();
		linkedList.addElement(1);
		linkedList.addElement(2);
		linkedList.addElement(3);
		linkedList.addElement(4);
		linkedList.addElement(5);
		linkedList.printList();
		
		linkedList.removeElement(1);
		linkedList.printList();
		linkedList.removeElement(5);
		linkedList.printList();
		linkedList.removeElement(3);
		linkedList.printList();
		linkedList.removeElement(2);
		linkedList.printList();
		linkedList.removeElement(4);
		linkedList.printList();
		
	}
}


