package com.gdw888.datastructures;

import java.util.ArrayList;
import java.util.List;


//      1
//  3   2   4
//5   6
// Post:    563241
// pre :    135624
// inorder: 536124

public class TreeTraversals {

	class Node{
		int val;
		List <Node> children;
		
		public Node(int val) {
			this.val=val;
			children = null;
		}
		public Node(int val, List <Node> children) {
			this.val = val;
			this.children = children;
		}
	}
	
	public static void main (String[] args) {
		TreeTraversals postOrder = new TreeTraversals();
		postOrder.init();
	}
	
	public void init() {
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		List <Node> nodes = new ArrayList<Node>();
		nodes.add(node5);
		nodes.add(node6);
		Node node3 = new Node(3,nodes);
		
		List <Node> nodes2 = new ArrayList<Node>();
		Node node2 = new Node(2);
		Node node4 = new Node(4);
		nodes2.add(node3);
		nodes2.add(node2);
		nodes2.add(node4);
		Node node1 = new Node(1, nodes2);
		
		List <Integer> answer1 = postOrder(node1);
		List <Integer> answer2 = preOrder(node1);
		List <Integer> answer3 = inOrder(node1);
		
		System.out.println(answer1.toString());
		System.out.println(answer2.toString());
		System.out.println(answer3.toString());
	}
	
	public List<Integer> postOrder(Node root){
		
		List <Integer> answer =new ArrayList<>();
		postOrder(root, answer);
		return answer;
	}
	
	public List<Integer> preOrder(Node root){
		
		List <Integer> answer =new ArrayList<>();
		preOrder(root, answer);
		return answer;
	}
	
	public List<Integer> inOrder(Node root){
		
		List <Integer> answer =new ArrayList<>();
		inOrder(root, answer);
		return answer;
	}

	public void postOrder(Node curNode, List<Integer> order) {
		
		if (curNode.children != null) {
			for (Node child: curNode.children) {
				postOrder(child, order);
			}
		}
		
		order.add(curNode.val);
	}
	
	public void preOrder(Node curNode, List<Integer> order) {
		order.add(curNode.val);
		
		if (curNode.children != null) {
			for (Node child: curNode.children) {
				preOrder(child, order);
			}
		}
	}
	
	public void inOrder(Node curNode, List<Integer> order) {
		
		if (curNode.children != null && curNode.children.get(0) != null) {
			inOrder(curNode.children.get(0), order);
		}
		
		order.add(curNode.val);
		
		if (curNode.children != null && curNode.children.get(1) != null) {
			inOrder(curNode.children.get(1), order);
		}
	}
}
