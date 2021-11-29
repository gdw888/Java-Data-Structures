package com.gdw888.datastructures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BinaryTreeExampleTwo extends BinaryTreeExample{
	
	public BinaryTreeExampleTwo(@Autowired BinaryTree binaryTree, @Value("${nodeListBinaryTreeExampleTwo}") String nodeList) {
		super(binaryTree, nodeList);
	}
}
