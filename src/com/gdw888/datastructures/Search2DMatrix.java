package com.gdw888.datastructures;

public class Search2DMatrix{

	public static void main(String[] args) {
		Search2DMatrix sm = new Search2DMatrix();
		sm.init();
	}

	public void init() {

		int[][] arrayNum = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int target = 23;
		
		
		System.out.println(searchMatrix(arrayNum, target));
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		return searchMatrix(matrix, target, 0, matrix.length, 0, matrix[0].length);
	}
	
	public boolean searchMatrix(int[][] matrix, int target, int x1, int x2, int y1, int y2) {
		int tempX, tempY;
		
		if (x1 == x2 && y1 == y2) {
			if (matrix[x1][y1] == target) {
				return true;
			}else{
				return false;
			}
		}else if (x1 != x2){
		    tempX = (x1+x2)/2;
			if (matrix[tempX][matrix[0].length-1] < target) {
				if (tempX == 0) {
					x1++;
				}else {
					x1 = tempX;
				}
				
			}else {
				if (tempX == 0) {
					x2--;
				}else {
					x2 = tempX;
				}
			}
		}else if (y1 != y2) {
			tempY = (y1+y2)/2;
			if (matrix[x1][tempY] >= target) {
				if (tempY == 0) {
					y2--;
				}else {
					y2 = tempY;
				}
			}else {
				if (tempY== 0) {
					y1++;
				}else {
					y1 = tempY;
				}
				
			}
		}
		System.out.println(x1 +" "+ x2 + " "+ y1 +" "+y2);

		return searchMatrix(matrix, target, x1, x2 ,y1, y2);
	}

}
