import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		SpiralMatrix test = new SpiralMatrix();
//		int[][] matrix = new int[][] {
//			{1, 2, 3, 4, 5},
//			{6, 7, 8, 9, 10},
//			{11, 12, 13, 14, 15},
//			{16, 17, 18, 19, 20}
//		};
		int[][] matrix = new int[][] {
			{7},
			{9},
			{6}
		};
		System.out.println(test.spiralOrder(matrix));
	}
}
