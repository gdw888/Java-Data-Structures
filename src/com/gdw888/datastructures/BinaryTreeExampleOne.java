package com.gdw888.datastructures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BinaryTreeExampleOne extends BinaryTreeExample {
	
	public BinaryTreeExampleOne(@Autowired BinaryTree binaryTree, @Value("${nodeListBinaryTreeExampleOne}") String nodeList) {
		super(binaryTree, nodeList);
	}
}
