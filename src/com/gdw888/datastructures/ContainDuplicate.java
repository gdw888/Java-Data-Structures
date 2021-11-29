package com.gdw888.datastructures;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class ContainDuplicate implements CodingSolution {

	private int[] integerArray;
	// [1,2,3,1] true
	// [1,2,3,4] false
	/*
	public static void  main (String args[]) {
		ContainDuplicate containDuplicate = new ContainDuplicate();
		
		int[] list = {1,2,3,1};
		System.out.println(containDuplicate.checkDuplicate(list));
		
		int[] list2 = {1,2,3,4};
		System.out.println(containDuplicate.checkDuplicate(list2));
	}
	*/
	
	public boolean checkDuplicate(int[] num){
		boolean result = false;

		HashMap<Integer,Integer> hashMap = new HashMap<>();
		
		for (int i = 0; i < num.length; i++) {
			if (hashMap.get(num[i]) != null) {
				return true;
			}
			hashMap.put(num[i], num[i]);
		}
		
		return result;
	}

	@Override
	public String getQuestionName() {
		return "ContainDuplicate";
	}

	@Override
	public boolean isBinaryTree() {
		return false;
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

	@Override
	public <T> T solution(Class<T> type) {
		return type.cast(checkDuplicate(integerArray));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Class<T> getSolutionReturnType() {
		return (Class<T>) Boolean.class;
	}

	@Override
	public boolean isIntegerArray() {
		return true;
	}

	@Override
	public <T> void setExample(T example) {
		this.integerArray = (int[]) example;
		
	}
}
