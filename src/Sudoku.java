
public class Sudoku {
	public boolean isValidSudoku (char[][] board) {
		if(!isValidRow(board)) return false;
		if(!isValidColumn(board)) return false;
		if(!isValidSquare(board)) return false;
		
		return true;
	}
	
	private boolean isValidRow(char[][] board) {
		for(int i = 0; i < board.length; i++) {
			int[] record = new int[board[0].length];
			for(int j = 0; j < board[0].length; j++) {
				if('1' <= board[i][j] && board[i][j] <= '9') {
					if(record[board[i][j] - '1'] != 0) return false;
					record[board[i][j] - '1'] = board[i][j] - '0';
				}
			}
		}
		
		return true;
	}
	
	private boolean isValidColumn(char[][] board) {
		for(int j = 0; j < board.length; j++) {
			int[] record = new int[board[0].length];
			for(int i = 0; i < board[0].length; i++) {
				if('1' <= board[i][j] && board[i][j] <= '9') {
					if(record[board[i][j] - '1'] != 0) return false;
					record[board[i][j] - '1'] = board[i][j] - '0';
				}
			}
		}
		
		return true;
	}
	
	private boolean isValidSquare(char[][] board) {
		for(int squareNum = 0; squareNum < 9; squareNum++) {
			int rowDown = (squareNum / 3) * 3;
			int columnDown = (squareNum % 3) * 3;
			
			int[] record = new int[board[0].length];
			for(int i = rowDown; i <= rowDown + 2; i++) {
				for(int j = columnDown; j <= columnDown + 2; j++) {
					if('1' <= board[i][j] && board[i][j] <= '9') {
						if(record[board[i][j] - '1'] != 0) return false;
						record[board[i][j] - '1'] = board[i][j] - '0';
					}
				}
			}
		}
		
		return true;
	}
}
