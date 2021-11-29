package com.gdw888.datastructures;

public class MergingTwoBinaryTree {

	public static void main(String args[]) {
		MergingTwoBinaryTree mergetree = new MergingTwoBinaryTree();
		mergetree.init();
	}
	
	public void init() {
		// tree1:
		Node node5a = new Node(5);
		Node node3a = new Node(3,node5a,null);
		Node node2a = new Node(2);
		Node node1a = new Node(1, node3a, node2a);
		
		// tree2:
		Node node4 = new Node(4);
		Node node1 = new Node(1,null,node4);
		Node node7 = new Node(7);
		Node node3 = new Node(3, null, node7);
		Node node2 = new Node(2,node1, node3);
		
		Node answer = new Node();;
		
		mergeTree(answer,node1a,node2);
		

		//Node.printBreathFirst(answer);
		
	}
	
	public void mergeTree(Node answer, Node tree1, Node tree2) {
		
		if (tree1 != null && tree2 != null) {
			answer.setValue(tree1.getValue()+tree2.getValue());
			answer.setLeft(new Node());
			answer.setRight(new Node());

			mergeTree(answer.getLeft(), tree1.getLeft(), tree2.getLeft());
			mergeTree(answer.getRight(), tree1.getRight(), tree2.getRight());
		}else if (tree1 != null) {
			
			answer.setValue(tree1.getValue());
			answer.setLeft(new Node());
			answer.setRight(new Node());
			
			
			mergeTree(answer.getLeft(), tree1.getLeft(), null);
			mergeTree(answer.getRight(), tree1.getRight(), null);
		}else if (tree2 != null) {
			answer.setValue(tree2.getValue());
			answer.setLeft(new Node());
			answer.setRight(new Node());
			
			mergeTree(answer.getLeft(), null, tree2.getLeft());
			mergeTree(answer.getRight(), null, tree2.getRight());
		}else {
			return;
		}
	}
}
