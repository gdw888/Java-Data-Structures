package com.gdw888.datastructures;

import java.util.HashMap;

public class TwoSum {

	public static void main (String[] args) {
		TwoSum ts = new TwoSum();
		ts.init();
	}

	public void init() {
		// TODO Auto-generated method stub
		int nums[] = {2,7,11,15};
		int target = 9;
		
		int[] result = twoSum(nums, target);
		System.out.print(result[0]+","+result[1]);
	}
	
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap <Integer,Integer> hashmap = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			hashmap.put(nums[i], i);
		}
		
		for (int index1=0; index1<nums.length; index1++) {
			int num1 = nums[index1];
			int num2 = target - num1;
			Integer index2 = hashmap.get(num2);

			if (index2 != null) {
				result[0] = index1;
				result[1] = index2;
				break;
			}
		}
		return result;
	}
}
