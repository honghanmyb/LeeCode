
public class GameOfLife {
	public void gameOfLife(int[][] board) {
		int[][] nextGen = new int[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				nextGen[i][j] = findLive(i, j, board);
			}
		}
		
		board = nextGen;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	private int findLive(int i, int j, int[][] board) {
		int count = 0;
		if(i != 0) {
			if(board[i - 1][j] == 1) count++;
			if(j != 0) {
				if(board[i - 1][j - 1] == 1) count++;
			}
			if(j != board[0].length - 1) {
				if(board[i - 1][j + 1] == 1) count++;
			}
		}
		if(i != board.length - 1) {
			if(board[i + 1][j] == 1) count++;
			if(j != 0) {
				if(board[i + 1][j - 1] == 1) count++;
			}
			if(j != board[0].length - 1) {
				if(board[i + 1][j + 1] == 1) count++;
			}
		}
		if(j != 0) {
			if(board[i][j - 1] == 1) count++;
		}
		if(j != board[0].length - 1) {
			if(board[i][j + 1] == 1) count++;
		}
		if(board[i][j] == 1) {
			if(count == 2 || count == 3) return 1;
			return 0;
		}
		if(count == 3) return 1;
		return 0;
	}
}
