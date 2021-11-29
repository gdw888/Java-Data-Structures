package com.gdw888.datastructures;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {	
	
	public static void main (String args[]) {
		PascalsTriangle pt = new PascalsTriangle();
		pt.pascalSolution(5);
	}
	
	public List<List<Integer>> pascalSolution(int num){
		
		List<List<Integer>> answer = new ArrayList<>();
		
		if (num == 0) {
			return answer;
		}

		List<Integer> firstRow = new ArrayList<>();
		firstRow.add(1);
		answer.add(firstRow);
		
		for (int i = 1; i < num; i++){
			List<Integer> curRow = new ArrayList<>();
			List<Integer> preRow = answer.get(i-1);
			curRow.add(1);
			
			for (int j = 1; j < preRow.size(); j++)
			{
				curRow.add(preRow.get(j-1) + preRow.get(j));
			}
			
			curRow.add(1);
			answer.add(curRow);
		}
	
		System.out.print(answer.toString());
		return answer;
	}
}
