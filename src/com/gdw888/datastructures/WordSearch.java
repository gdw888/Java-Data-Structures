package com.gdw888.datastructures;

public class WordSearch {
	int row,column;
	
	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		ws.init();
	}
	
	public void init() {
		
		char[][] board= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED"; //true
					  // "SEE";  //true
					  // "ABCB"; //false
		
		System.out.println(exist(board,word));
		
	}
	
	public boolean exist(char[][] board, String word) {
		boolean result = false;
		boolean[][] visited = null;
		char firstWord;
		
		if (board == null || board.length == 0 || word.length() == 0) {
			return result;
		}
		
		firstWord = word.charAt(0);
		row = board.length;
		column = board[0].length;
		visited = new boolean[row][column];
		
		for (int x = 0; x < row; x++) {
			for (int y=0; y < column; y++) {
				visited[x][y] = false;
			}
		}
		
		for (int x = 0; x < row; x++) {
			for (int y=0; y < column; y++) {
				if (board[x][y] == firstWord) {
					if (wordPathExist(board, visited, x, y, word, 0)) {
						return true;
					}
				}
			}
		}
		
		
		return result;
	}
	
	public boolean wordPathExist(char[][] board, boolean[][] visited, int x, int y, String word, int cur_index) {
		
		if (x < 0 || x >= row || y < 0 || y >= column || visited[x][y]) {
			return false;
		}else if (word.length() == cur_index) {
			return true;
		}
		
		char character = word.charAt(cur_index);
		
		if (board[x][y] == character) {
			visited[x][y] = true;
			
			return (wordPathExist(board, visited, x-1, y, word, cur_index+1) ||
					wordPathExist(board, visited, x+1, y, word, cur_index+1) ||
					wordPathExist(board, visited, x, y-1, word, cur_index+1) ||
					wordPathExist(board, visited, x, y+1, word, cur_index+1) );
		}else {
			return false;
		}
	}

}
