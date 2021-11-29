package com.gdw888.datastructures;

public class NumIslands {

	// [1,1,0,0,1]
	// [1,0,1,0,1]
	// [0,1,0,1,0]
	// [0,1,0,1,1]
	// [1,1,0,1,0]
	
	public static void  main (String args[]) {
		int[][] grid = {{1,1,0,0,1},{1,0,1,0,1},{0,1,0,1,0},{0,1,0,1,1},{1,1,0,1,0}};
		
		NumIslands numIslands = new NumIslands();
		System.out.print(numIslands.findIslands(grid));
	}
	
	public int findIslands(int[][] grid) {
		int answer = 0;
		
		for (int i=0; i < grid.length; i++) {
			for (int j=0; j< grid[i].length; j++) {

				if (grid[i][j] == 1) {
					answer++;
					deleteIsland(grid,i,j);
				}
			}
		}
		return answer;
	}
	
	public void deleteIsland(int[][] grid, int i, int j){
		if (i < 0 || i > grid.length-1 || j <0 || j >grid[i].length-1 || grid[i][j] == 0) {
			return;
		}
		
		// remove current coordinate
		grid[i][j] = 0;
		
		// recursively check the adjacent coordinates
		deleteIsland(grid,i+1,j);
		deleteIsland(grid,i-1,j);
		deleteIsland(grid,i,j+1);
		deleteIsland(grid,i,j-1);
	}
	
}
