import java.awt.Point;
import java.util.*;
public class SudokuSolver {
	private char[] numbers = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	public void solveSudoku(char[][] board) {
		solve(board, new Point(0, 0));
	}
	
	private boolean solve(char[][] board, Point currentCoordinate) {
		if(currentCoordinate == null) {
			return true;
		}
		Point nextCoordinate = getNext(currentCoordinate);

		if(board[currentCoordinate.x][currentCoordinate.y] != '.') {
			return solve(board, nextCoordinate);
		}
		
		for(char number: numbers) {
			if(satisfyCurrentBoard(board, currentCoordinate, number)) {
				board[currentCoordinate.x][currentCoordinate.y] = number;
				if(solve(board, nextCoordinate)) {
					return true;
				}else {
					board[currentCoordinate.x][currentCoordinate.y] = '.';
				}
			}
		}
		return false;
	}
	
	private boolean satisfyCurrentBoard(char[][] board, Point coordinate, char number) {
		for(char ch: board[coordinate.x]) {
			if(ch == number) {
				return false;
			}
		}
		
		for(int i = 0; i < board.length; i++) {
			if(board[i][coordinate.y] == number) {
				return false;
			}
		}
		
		for(int i = coordinate.x / 3 * 3; i < coordinate.x / 3 * 3 + 3; i++) {
			for(int j = coordinate.y / 3 * 3; j < coordinate.y / 3 * 3 + 3; j++) {
				if(board[i][j] == number) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private Point getNext(Point currentCoordinate) {
		if(currentCoordinate.y != 8) {
			return new Point(currentCoordinate.x, currentCoordinate.y + 1);
		}
		if(currentCoordinate.x != 8) {
			return new Point(currentCoordinate.x + 1, 0);
		}
		
		return null;
	}
} 
