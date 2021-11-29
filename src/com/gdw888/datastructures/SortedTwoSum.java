package com.gdw888.datastructures;

public class SortedTwoSum {

	// numbers = {2,7,11,15}
	// target = 9
	public static void main(String args[]) {
		SortedTwoSum sortedTwoSum = new SortedTwoSum();
		sortedTwoSum.init();
	}
	
	public void init() {
		int[] numbers = {2,7,11,15,20,30,40};
		int target = 18;
		int[] answer = findTwoIndexes(numbers,target);
		System.out.print(answer[0] + ","+answer[1]);
	}
	
	public int[] findTwoIndexes(int[] numbers, int target) {
		int[] answer = new int[2];
		answer[0] = -1;
		answer[1] = -1;
		
		int head = 0;
		int tail = numbers.length-1;
		
		while (head != tail) {
			int sum = numbers[head] + numbers[tail];
			
			if (sum < target) {
				head++;
			}else if (sum > target) {
				tail--;
			}else {
				answer[0] = head;
				answer[1] = tail;
				break;
			}
		}
		
		
		return answer;
	}
	
	
}
