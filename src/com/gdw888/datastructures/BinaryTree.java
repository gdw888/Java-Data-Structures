package com.gdw888.datastructures;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BinaryTree extends Node{
	
	private Node root;

	public void insertNode(int value) {
		Node temp = this.root;
		
		if (temp != null) {
			while (temp != null){
				if ( temp.getValue() > value ){
					if ( temp.getLeft() == null) {
						temp.left = new Node(value);
						break;
					}else{
						temp = temp.getLeft();
					}
				} else if ( temp.getValue() < value){
					if ( temp.getRight() == null) {
						temp.right = new Node(value);
						break;
					}else{
						temp = temp.getRight();
					}
				}
			}
		}else {
			this.root = new Node(value);
		}
	}
	
	private void insertChildNodes(Node child) {
		if (child != null){
			insertNode(child.getValue());
			insertChildNodes(child.getLeft());
			insertChildNodes(child.getRight());
		}
	}
	
	public void removeNode(int value){
		Node deleteNode = this.root;
		Node oldNode = deleteNode;
		
		while (deleteNode != null){
			if( deleteNode.getValue() == value) {
				//remove
				if (deleteNode.getLeft() == null && deleteNode.getRight() == null){
					if ( oldNode.getLeft().getValue() == value){
						oldNode.left = null;
					}
					
					if ( oldNode.getRight().getValue() == value){
						oldNode.right = null;
					}
					break;
				}
				
				if(deleteNode.getLeft() != null)
				{
					oldNode = deleteNode;
					Node replaceNode = deleteNode.getLeft();
					Node childNodes;

					// find the right most node
					while (replaceNode.getRight() != null) {
						oldNode = replaceNode;
						replaceNode = replaceNode.getRight();
					}
					
					if ( oldNode.getLeft().getValue() == replaceNode.getValue()){
						oldNode.left = null;
					}
					
					if ( oldNode.getRight().getValue() == replaceNode.getValue()){
						oldNode.right = null;
					}

					childNodes = replaceNode.getLeft();
					deleteNode.setValue(replaceNode.getValue());
					
					insertChildNodes(childNodes);
					break;
				}
				
				if(deleteNode.getRight() != null)
				{
					Node replaceNode = deleteNode.getRight();
					oldNode = deleteNode;
					Node childNodes;

					// find the right most node
					while (replaceNode.getLeft() != null) {
						oldNode = replaceNode;
						replaceNode = replaceNode.getLeft();
					}
					
					if ( oldNode.getLeft().getValue() == replaceNode.getValue()){
						oldNode.left = null;
					}
					
					if ( oldNode.getRight().getValue() == replaceNode.getValue()){
						oldNode.right = null;
					}
					
					childNodes = replaceNode.getRight();
					deleteNode.setValue(replaceNode.getValue());
					
					insertChildNodes(childNodes);
					break;
				}
			}else if ( deleteNode.getValue() > value ){
				oldNode = deleteNode;
				deleteNode = deleteNode.getLeft();
			}else if ( deleteNode.getValue() < value){
				oldNode = deleteNode;
				deleteNode = deleteNode.getRight();
			}
		}
	}
	
	private void printBinaryTreeHelper(Queue<Node> queue, StringBuilder str) {
		if (!queue.isEmpty()) {
			Node temp = queue.poll();
			
			str.append("Node: "+ temp.getValue() + "\n");
			if (temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}
			
			if (temp.getRight() != null){
				queue.add(temp.getRight());
			}
			printBinaryTreeHelper(queue, str);
		}
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		printBinaryTreeHelper(queue, str);
		
		return str.toString();
	}

	protected Node getRoot() {
		return root;
	}

	protected void setRoot(Node root) {
		this.root = root;
	}
}
