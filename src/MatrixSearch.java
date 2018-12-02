
public class MatrixSearch {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0) return false;
		int stop = Integer.MAX_VALUE;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < Math.min(matrix[0].length, stop); j++) {
				if(matrix[i][j] == target) return true;
				if(matrix[i][j] > target) {
					stop = j;
					break;
				}
			}
		}
		
		return false;
	}
}
