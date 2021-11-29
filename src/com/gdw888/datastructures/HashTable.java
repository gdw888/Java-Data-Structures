package com.gdw888.datastructures;

import java.util.ArrayList;

public class HashTable {
	
	int hashBucketSize;
	ArrayList<hashNode> hashList[];
	
	public class hashNode {
		private int key;
		private String value;
		
		public hashNode(int key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public int getKey() {
			return this.key;
		}
		
		public String getValue() {
			return this.value;
		}
		
		public String toString() {
			return "["+Integer.toString(key)+":"+value+"]";
		}
	}
	
	public HashTable(int hashBucketSize) {
		this.hashBucketSize = hashBucketSize;
		hashList = new ArrayList[hashBucketSize];
		
		for (int i = 0; i < hashBucketSize; i++) {
			hashList[i] = new ArrayList<hashNode>();
		}
	}
	
	private ArrayList<hashNode> gethashBucket(int key) {
		return hashList[key % hashBucketSize];
	}
	
	private int getIndexOfNodeFromKey(ArrayList<hashNode> hashBucket, int key) {
		int index;
		boolean isKeyFound = false;
		
		for ( index = 0; index < hashBucket.size(); index++ ) {
			if (hashBucket.get(index).getKey() == key) {
				isKeyFound = true;
				break;
			}
		}
		
		if (isKeyFound)
			return index;
		else
			return -1;
	}
	
	public void insert(int key, String value) {
		
		ArrayList<hashNode> hashBucket = gethashBucket(key);
		
		if (getIndexOfNodeFromKey(hashBucket, key) == -1) {
			hashBucket.add(new hashNode(key,value));
		}
	}
	
	public void delete(int key) {
		ArrayList<hashNode> hashBucket = gethashBucket(key);
		int nodeIndex = getIndexOfNodeFromKey(hashBucket, key);
		
		if ( nodeIndex != -1 ) {
			hashBucket.remove(nodeIndex);
		}
	}

	public String getValue(int key) {
		String value = "";
		ArrayList<hashNode> hashBucket = gethashBucket(key);
		int nodeIndex = getIndexOfNodeFromKey(hashBucket, key);
		
		if ( nodeIndex != -1 ) {
			value = hashBucket.get(nodeIndex).getValue();
		}

		return value;
	}
	
	public void printHashTable() {
		int hashBucketNumber = 1;
		for (ArrayList<hashNode> hashBucket : hashList) {
			
			System.out.print("HashBucket["+hashBucketNumber+"]: ");
			hashBucketNumber++;
			
			for ( hashNode hashNode :hashBucket ) {
				System.out.print(hashNode.toString() + " ");
			}
			
			System.out.println("");
		}
	}

	
	public static void main(String args[]) {
		HashTable ht = new HashTable(5);
		ht.insert(0, "TERRY0");
		ht.insert(1, "TERRY1");
		ht.insert(2, "TERRY2");
		ht.insert(3, "TERRY3");
		ht.insert(4, "TERRY4");
		ht.insert(5, "TERRY5");
		ht.insert(6, "TERRY6");
		ht.insert(7, "TERRY7");
		ht.insert(8, "TERRY8");
		ht.insert(9, "TERRY9");
		ht.insert(10, "TERRY10");
		ht.insert(10, "TERRY15");
		
		
		ht.printHashTable();
		System.out.println("Deleting key 10");
		ht.delete(10);

		ht.printHashTable();
		
		System.out.println(ht.getValue(10));
		System.out.println(ht.getValue(5));
		System.out.println(ht.getValue(0));
		System.out.println(ht.getValue(11));
	}
	
}
