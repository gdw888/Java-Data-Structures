package com.gdw888.datastructures;

import java.util.Stack;

public class removeDuplicates {

	public static void main(String[] args) {
		removeDuplicates rd = new removeDuplicates();
		rd.init();
	}
	
	public void init() {
		// TODO Auto-generated method stub
		String s = "abbaca";
		System.out.print(removeDuplicatesSolution(s));
		
	}
	
	public String removeDuplicatesSolution(String s){
		StringBuilder result =new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for (int i=0; i<s.length(); i++) {
			if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
				stack.pop();
			}else {
				stack.add(s.charAt(i));
			}
		}
		

		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		
		return result.reverse().toString();
	}
}
