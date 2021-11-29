package com.gdw888.datastructures;

public class Node {

	private int value;
	protected Node left;
	protected Node right;
	
	public Node() {
	}
	
	public Node(int value) {
		this.setValue(value);
		this.setLeft(null);
		this.setRight(null);
	}
	
	public Node(int value, Node left, Node right) {
		this.setValue(value);
		this.setLeft(left);
		this.setRight(right);
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	/*
	public void printBreathFirst(Node node) {
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(node);
		printBreathFirst(q);
		System.out.println("");
	}
	
	public void printBreathFirst(Queue<Node> q) {
		if (q.size() == 0)
		{
			return;
		}
		
		Node curNode = q.poll();
		
		System.out.print(curNode.val+" ");
		if (curNode.left != null) {
			q.add(curNode.left);
		}
		if (curNode.right != null) {
			q.add(curNode.right);
		}
		
		printBreathFirst(q);
	}
	*/
}
