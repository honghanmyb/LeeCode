
public class MatrixSearch {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0) return false;
		int stopCol = Integer.MAX_VALUE;
		int stopRow = matrix.length;
		
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == target) return true;
			if(matrix[i][0] > target) {
				stopRow = i;
				break;
			}
		}
		for(int i = 0; i < Math.min(matrix.length, stopRow); i++) {
			for(int j = 0; j < Math.min(matrix[0].length, stopCol); j++) {
				if(matrix[i][j] == target) return true;
				if(matrix[i][j] > target) {
					stopCol = j;
					break;
				}
			}
		}
		
		return false;
	}
}
