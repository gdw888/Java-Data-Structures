package com.gdw888.datastructures;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class InvertTree implements CodingSolution{

	private BinaryTree bt;
	
	public InvertTree(BinaryTree bt) {
		this.bt = bt;
	}

	public void invertTree(Node node) {
		if (node == null)
			return;
		Node temp = node.getLeft();
		node.setLeft(node.getRight());
		node.setRight(temp);
		
		invertTree(node.getLeft());
		invertTree(node.getRight());
	}

	@Override
	public boolean isBinaryTree() {
		return true;
	}
	
	@Override
	public String getQuestionName() {
		return "InvertTree";
	}

	@Override
	public boolean isHashTable() {
		return false;
	}

	@Override
	public boolean isLinkedList() {
		return false;
	}

	@Override
	public boolean isGraph() {
		return false;
	}

	
	public <T> T solution() {
		invertTree(bt.getRoot());
		return null;
	}
	
	@Override
	public <T> T solution(Class<T> type) {
		invertTree(bt.getRoot());
		return null;
	}

	@Override
	public <T> Class<T> getSolutionReturnType() {
		return null;
	}

	@Override
	public boolean isIntegerArray() {
		return false;
	}

	@Override
	public <T> void setExample(T example) {
		this.bt = (BinaryTree) example;
	}

}
