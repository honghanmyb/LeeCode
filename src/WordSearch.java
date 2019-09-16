
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		boolean[][] hasUsed = new boolean[board.length][board[0].length];
		int currentCharIndex = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(findWord(board, hasUsed, word, currentCharIndex, i, j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean findWord(char[][] board, boolean[][] hasUsed, String word, int currentCharIndex, int i, int j) {
		char currentChar = word.charAt(currentCharIndex);
		if(currentChar != board[i][j]) {
			return false;
		}
		if(hasUsed[i][j] == true) {
			return false;
		}
		hasUsed[i][j] = true;
		if(currentCharIndex == word.length() - 1) {
			return true;
		}
		if(i < board.length - 1) {
			if(findWord(board, hasUsed, word, currentCharIndex + 1, i + 1, j)) {
				return true;
			}
		}
		if(i > 0) {
			if(findWord(board, hasUsed, word, currentCharIndex + 1, i - 1, j)) {
				return true;
			}
		}
		if(j < board[0].length - 1) {
			if(findWord(board, hasUsed, word, currentCharIndex + 1, i, j + 1)) {
				return true;
			}
		}
		if(j > 0) {
			if(findWord(board, hasUsed, word, currentCharIndex + 1, i, j - 1)) {
				return true;
			}
		}
		hasUsed[i][j] = false;
		return false;
	}
}
