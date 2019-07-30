
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0) {
			return false;
		}
		if(matrix[0].length == 0) {
			return false;
		}
		int rowIndex = -1;
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target) {
				rowIndex = i;
				break;
			}
		}
		if(rowIndex == -1) {
			return false;
		}
		int left = 0, right = matrix[0].length;
		while(left < right) {
			int middleElement = matrix[rowIndex][(left + right) /2];
			if(middleElement == target) {
				return true;
			}
			if(left == right -1) {
				break;
			}
			if(middleElement < target) {
				left = (left + right) / 2;
				continue;
			}
			if(middleElement > target) {
				right = (left + right) / 2;
				continue;
			}
		}
		
		if(matrix[rowIndex][left] == target || matrix[rowIndex][right] == target) {
			return true;
		}
		return false;
	}
}
