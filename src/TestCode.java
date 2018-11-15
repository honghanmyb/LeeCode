import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		int[][] matrix1 = {
				{1, 1, 1},
				{1, 0, 1},
				{1, 1, 1}
		};
		int[][] matrix2 = {
				{0, 1, 2, 0},
				{3, 4, 5, 2},
				{1, 3, 1, 5}
		};
		SetMatrixZeros test = new SetMatrixZeros();
		test.setZeros(matrix1);
		test.setZeros(matrix2);
		for(int i = 0; i < matrix1.length; i++) {
			for(int j = 0; j < matrix1[0].length; j++) {
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println("");
		}
		
		for(int i = 0; i < matrix2.length; i++) {
			for(int j = 0; j < matrix2[0].length; j++) {
				System.out.print(matrix2[i][j] + " ");
			}
			System.out.println("");
		}
		
		
	}
}
