package com.gdw888.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSubset {

	String[] A = {"amazon","apple","facebook","google","leetcode"};
	String[] B = {"e","oo"};
	
	public static void main(String args[]) {
		WordSubset ws = new WordSubset();
		ws.init();
	}
	
	public void init() {
		List <String> result = new ArrayList<>();
		
		for (int i=0; i<A.length; i++) {
			char[] word = A[i].toCharArray();
			HashMap<String,Integer> hashMap = new HashMap<>();
			boolean isSubset = true;
			
			for (int j = 0; j < word.length; j++) {
				String key = ""+word[j];
				Integer value = hashMap.get(key);
				if (null == value) {
					value = 1;
				}else {
					value++;
				}
				hashMap.put(key, value);
			}
			
			for (int j = 0; j < B.length; j++) {
				char[] wordB= B[j].toCharArray();
				for (int k=0; k <wordB.length; k++) {
					String key = ""+wordB[k];
					Integer value = hashMap.get(key);
					if (value == null || value == 0) {
						isSubset = false;
						break;
					}
					else {
						hashMap.put(key, --value);
				}
				}
			}
			
			if (isSubset) {
				result.add(A[i]);
			}
		}
		
		for (String res : result) {
			System.out.println(res);
		}
	}
}
