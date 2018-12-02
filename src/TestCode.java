import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		MatrixSearch test = new MatrixSearch();
//		int[][] matrix = {
//				{
//					1,   4,  7, 11, 15
//				},
//				{
//					2,   5,  8, 12, 19
//				},
//				{
//					3,   6,  9, 16, 22
//				},
//				{
//					10, 13, 14, 17, 24
//				},
//				{
//					18, 21, 23, 26, 30
//				}
//		};
		
		int[][] matrix = {{1, 1}};
		
		System.out.println(test.searchMatrix(matrix, 2));
		
	}
}
