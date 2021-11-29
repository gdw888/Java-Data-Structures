package com.gdw888.datastructures;

public interface CodingSolution {
	public String getQuestionName();
	public <T> Class<T> getSolutionReturnType();
	public <T> T solution(Class<T> type);
	public <T> void setExample(T example);
	public boolean isBinaryTree();
	public boolean isHashTable();
	public boolean isLinkedList();
	public boolean isGraph();
	public boolean isIntegerArray();
}
