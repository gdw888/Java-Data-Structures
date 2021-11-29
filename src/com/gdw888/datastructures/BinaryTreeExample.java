package com.gdw888.datastructures;

public class BinaryTreeExample implements QuestionExample {

	private BinaryTree binaryTree;
	
	public BinaryTreeExample(BinaryTree binaryTree, String nodeList) {
		this.binaryTree = binaryTree;

		// parse nodeList to binary tree
		String[] tokens=nodeList.split(",");
		for (int i=0; i< tokens.length; i++) {
			binaryTree.insertNode(Integer.parseInt(tokens[i]));
		}
	}
	
	@Override
	public <T> T getExample() {
		return (T) binaryTree;
	}

	@Override
	public String exampleToString() {
		return binaryTree.toString();
	}
}
