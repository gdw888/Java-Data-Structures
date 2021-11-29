package com.gdw888.datastructures;

import java.util.HashMap;

public class LeastUsedCache {
	
	class Node{
		int value;
		Node next;
		Node prev;
		
		Node(int value){
			this.value = value;
			next = null;
			prev = null;
		}
	}
	
	class LinkedList{
		Node head, tail;
		
		public void add(Node node){
			if (head == null & tail == null) {
				head = node;
				tail = node;
			}else {
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
		}
		
		public void remove(Node node) {
			
			if(node.prev != null && node.next != null) {
				Node prevNode = node.prev;
				Node nextNode = node.next;	
				prevNode.next = nextNode;
				nextNode.prev = prevNode;
			}else if (node.prev != null){
				Node prevNode = node.prev;
				prevNode.next = null;
			}else if (node.next != null) {
				Node nextNode = node.next;
				nextNode.prev = null;
			}else {
				head = null;
				tail = null;
			}
		}

		public Node removeHead() {
			Node resultNode = null;
			
			if ( head != null ) {
			    resultNode = head;
				head = head.next;
				head.prev = null;
				
				resultNode.prev = null;
				resultNode.next = null;
			}
			
			return resultNode;
		}
		
		public String toString() {
			String result = "";
			Node travereNode = head;
			int count = 0;
			
			while (travereNode != null) {
				result += "["+count+"]" + travereNode.value + " ";
				travereNode = travereNode.next;
			}
			return result;
		}
	}


	int cacheSize, numElement;
	
	HashMap<Integer, Node> 	hashMap;
	LinkedList 				linkedList;
	
	public LeastUsedCache(int cacheSize) {
		
		this.cacheSize 	= cacheSize;
		this.hashMap 	= new HashMap<Integer, Node>();
		this.linkedList = new LinkedList();
		this.numElement = 0;
		
	}
	
	public void insert(int value) {
		
		Node node = hashMap.get(value);
		
		// The value being inserted already exists in the cache.
		if (node != null) {
			// Remove the node from the cache and place it to the tail;
			linkedList.remove(node);
			linkedList.add(node);
			return;
		}
		
		// The cache is full
		if (numElement == cacheSize) {
			// evict the least used node;
			Node evictedNode = linkedList.removeHead();
			hashMap.remove(evictedNode.value);
			numElement--;
		}
			
		// Add a new node;
		Node newNode = new Node(value);
		linkedList.add(newNode);
		hashMap.put(value, newNode);
		
		numElement++;
		
		return;
	}
	
	public int get(int key){
		int returnValue = -1;
		Node node = hashMap.get(key);
		// The value being inserted already exists in the cache.
		if (node != null) {
			// Remove the node from the cache and place it to the tail;
			linkedList.remove(node);
			linkedList.add(node);
			returnValue = node.value;
		}
		
		return returnValue;
	}
	
	public void printLUC() {
		System.out.print(linkedList.toString());
	}
	
	public static void main(String args[]) {
	
		LeastUsedCache luc = new LeastUsedCache(2);
		luc.insert(4);
		luc.insert(5);
		luc.insert(1);
		
		luc.printLUC();
		
		
		return;
	}
}
