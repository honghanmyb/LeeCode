import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		char[][] board = {
				{
					'5', '3', '.', '.', '7', '.', '.', '.', '.'
				},
				{
					'6', '.', '.', '1', '9', '5', '.', '.', '.'
				},
				{
					'.', '9', '8', '.', '.', '.', '.', '6', '.'
				},
				{
					'8', '.', '.', '.', '6', '.', '.', '.', '3'
				},
				{
					'4', '.', '.', '8', '.', '3', '.', '.', '1'
				},
				{
					'7', '.', '.', '.', '2', '.', '.', '.', '6'
				},
				{
					'.', '6', '.', '.', '.', '.', '2', '8', '.'
				},
				{
					'.', '.', '.', '4', '1', '9', '.', '.', '5'
				},
				{
					'.', '.', '.', '.', '8', '.', '.', '7', '9'
				}
		};
		
		SudokuSolver test = new SudokuSolver();
		test.solveSudoku(board);
		for(char[] row: board) {
			for(char ch: row) {
				System.out.print(ch + " ");
			}
			System.out.print("\n");
		}
	}
}
