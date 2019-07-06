import java.awt.Point;
import java.util.*;
public class SudokuSolver {
	private char[] numbers = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	private List<HashSet<Character>> rowSetList;
	private List<HashSet<Character>> columnSetList;
	private List<HashSet<Character>> blockSetList;
	public void solveSudoku(char[][] board) {
		setup(board);
		solve(board, new Point(0, 0));
	}

	private void setup(char[][] board) {
		rowSetList = new ArrayList<>(9);
		columnSetList = new ArrayList<>(9);
		blockSetList = new ArrayList<>();
		
		for(int i = 0; i < board.length; i++) {
			HashSet<Character> set = new HashSet<>();
			for(int j = 0; j < board[i].length; j++) {
				set.add(board[i][j]);
			}
			rowSetList.add(set);
		}
		
		for(int j = 0; j < board[0].length; j++) {
			HashSet<Character> set = new HashSet<>();
			for(int i = 0; i < board.length; i++) {
				set.add(board[i][j]);
			}
			columnSetList.add(set);
		}
		
		for(int i = 0; i < board.length; i++) {
			HashSet<Character> set = new HashSet<>();
			for(int j = i / 3 * 3; j < i / 3 * 3 + 3; j++) {
				for(int k = i % 3 * 3; k < i % 3 * 3 + 3; k++) {
					set.add(board[j][k]);
				}
			}
			blockSetList.add(set);
		}
	}
	
	private boolean solve(char[][] board, Point currentCoordinate) {
		if(currentCoordinate == null) {
			return true;
		}
		Point nextCoordinate = getNext(currentCoordinate);

		if(board[currentCoordinate.x][currentCoordinate.y] != '.') {
			return solve(board, nextCoordinate);
		}
		HashSet<Character> rowSet = rowSetList.get(currentCoordinate.x);
		HashSet<Character> columnSet = columnSetList.get(currentCoordinate.y);
		HashSet<Character> blockSet = blockSetList.get(currentCoordinate.x / 3 * 3 + currentCoordinate.y / 3);
		
		for(char number: numbers) {
			if(satisfyCurrentBoard(number, rowSet, columnSet, blockSet)) {
				board[currentCoordinate.x][currentCoordinate.y] = number;
				rowSet.add(number);
				columnSet.add(number);
				blockSet.add(number);
				if(solve(board, nextCoordinate)) {
					return true;
				}else {
					rowSet.remove(number);
					columnSet.remove(number);
					blockSet.remove(number);
					board[currentCoordinate.x][currentCoordinate.y] = '.';
				}
			}
			
		}
		return false;
	}
	
	private boolean satisfyCurrentBoard(char number, HashSet<Character> rowSet,
			HashSet<Character> columnSet, HashSet<Character> blockSet) {
		if(rowSet.contains(number)) {
			return false;
		}
		if(columnSet.contains(number)) {
			return false;
		}
		if(blockSet.contains(number)) {
			return false;
		}
		return true;
	}
	
	private boolean satisfyRow(char[][] board, Point currentCoordinate, char number) {
		HashSet<Character> set = new HashSet<>();
		set.add(number);
		for(char ch: board[currentCoordinate.x]) {
			if(ch != '.') {
				if(set.contains(ch)) {
					return false;
				}
				set.add(ch);
			}
		}
		
		return true;
	}
	
	private boolean satisfyColumn(char[][] board, Point currentCoordinate, char number) {
		HashSet<Character> set = new HashSet<>();
		set.add(number);
		for(int i = 0; i < board.length; i++) {
			char ch = board[i][currentCoordinate.y];
			if(ch != '.') {
				if(set.contains(ch)) {
					return false;
				}
				set.add(ch);
			}
		}
		return true;
	}
	
	private boolean satisfyBlock(char[][] board, Point currentCoordinate, char number) {
		HashSet<Character> set = new HashSet<>();
		set.add(number);
		
		for(int i = currentCoordinate.x / 3 * 3; i < currentCoordinate.x / 3 * 3 + 3; i++) {
			for(int j = currentCoordinate.y / 3 * 3; j < currentCoordinate.y / 3 * 3 + 3; j++) {
				char ch = board[i][j];
				if(ch != '.') {
					if(set.contains(ch)) {
						return false;
					}
					set.add(ch);
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
