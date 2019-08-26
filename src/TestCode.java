import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		MaximalSquare test = new MaximalSquare();
		char[][] matrix = new char[][] {
			{'0', '1', '1', '0', '1'},
			{'1', '0', '0', '1', '0'},
			{'0', '1', '1', '1', '0'},
			{'1', '1', '1', '1', '0'},
			{'1', '1', '1', '1', '1'},
			{'0', '0', '0', '0', '0'}
		};
		System.out.println(test.maximalSquare(matrix));
	}
}
