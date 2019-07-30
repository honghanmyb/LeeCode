import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		Search2DMatrix test = new Search2DMatrix();
		int[][] matrix = new int[][] {
			new int[] {1,   3,  5,  7},
			new int[] {10, 11, 16, 20},
			new int[] {23, 30, 34, 50}
		};
		System.out.println(test.searchMatrix(matrix, 7));
	}
}
