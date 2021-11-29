package com.gdw888.datastructures;

public class Stack {

	int sizeOfStack, head;
	boolean isEmpty, isfull;
	int stackArray[];
	
	public Stack(int size) {
		this.sizeOfStack = size;
		this.head = 0;
		this.isEmpty = true;
		this.isfull = false;
		stackArray = new int[this.sizeOfStack];
	}
	
	public void push(int value) {
		if ( !isfull ) {

			stackArray[head] = value;
			
			if (head == 0){
				isEmpty = false;
			}
			
			if ( head == sizeOfStack -1 ) {
				isfull = true;
			} else
			{
				head++;
			}
		}
	}
	
	public int pop() {
		if ( !isEmpty() ) {
			int returnValue = stackArray[head--];
			
			if (head == 0) {
				isEmpty = true;
			}
			isfull = false;
			
			return returnValue;
		}
		return -1;
	}
	
	private boolean isEmpty() {
		return isEmpty;
	}
	
	public void printStack() {
		
		for ( int index = 0; index <= head; index++) {
			System.out.println("["+index+"]:"+stackArray[index]);
		}

	}
	
	public static void main (String args[]) {
		Stack stack = new Stack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		stack.printStack();
		
		System.out.println(stack.pop());
		
		stack.printStack();
	}
}
