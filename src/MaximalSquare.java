import java.util.Arrays;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if(matrix.length == 0) {
			return 0;
		}
		if(matrix[0].length == 0) {
			return 0;
		}
		
		int[] height = new int[matrix[0].length];
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		Arrays.fill(right, right.length - 1);
		int maxSquare = 0;
		for(int i = 0; i < matrix.length; i++) {
			int leftBound = 0, rightBound = right.length - 1;
			for(int j = right.length - 1; j >= 0; j--) {
				if(matrix[i][j] == '0') {
					rightBound = j - 1;
					right[j] = right.length - 1;
				}else {
					right[j] = Math.min(right[j], rightBound);
				}
			}
			for(int j = 0; j < left.length; j++) {
				if(matrix[i][j] == '0') {
					leftBound = j + 1;
					left[j] = 0;
					height[j] = 0;
				}else {
					left[j] = Math.max(left[j], leftBound);
					height[j]++;
					int currentLength = Math.min(height[j], right[j] - left[j] + 1);
					maxSquare = Math.max(maxSquare, currentLength * currentLength);
				}
			}
		}
		
		return maxSquare;
	}
}
