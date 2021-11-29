package com.gdw888.datastructures;

abstract public class IntegerArrayExample implements QuestionExample {

	private int[] integerArray;
	
	public IntegerArrayExample(String nodeList) {

		// parse nodeList to binary tree
		String[] tokens=nodeList.split(",");
		integerArray = new int[tokens.length];
		
		for (int i=0; i< tokens.length; i++) {
			integerArray[i] = Integer.parseInt(tokens[i]);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getExample() {
		return (T) integerArray;
	}
	
	@Override 
	public String exampleToString() {
		String result = "";
		for (int i=0; i<integerArray.length; i++) {
			result+= integerArray[i]+" ";
		}
		return result;
	}
}
