import java.util.Arrays;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		int maxRec = 0;
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return maxRec;
		}
		int[] height = new int[matrix[0].length];
		int[] left = new int[matrix[0].length], right = new int[matrix[0].length];
		Arrays.fill(right, right.length - 1);
		for(int i = 0; i < matrix.length; i++) {
			int rightBound = right.length - 1;
			for(int j = right.length - 1; j >= 0; j--) {
				if(matrix[i][j] == '1') {
					right[j] = Math.min(right[j], rightBound);
					continue;
				}
				rightBound = j - 1;
				right[j] = right.length - 1;
			}
			int leftBound = 0;
			for(int j = 0; j < height.length; j++) {
				if(matrix[i][j] == '1') {
					height[j] += 1;
					left[j] = Math.max(left[j], leftBound);
					maxRec = Math.max(maxRec, height[j] * (right[j] - left[j] + 1));
					continue;
				}
				height[j] = 0;
				leftBound = j + 1;
				left[j] = 0;
			}
		}
		return maxRec;
	}
	
	private void initArrays(int[] height, int[] left, int[] right, char[][] matrix) {
		Arrays.fill(right, right.length - 1);
		int leftBound = 0;
		for(int i = 0; i < height.length; i++) {
			if(matrix[0][i] == '1') {
				height[i] = 1;
				leftBound = Math.min(leftBound, i);
				left[i] = leftBound;
				continue;
			}
			leftBound = i + 1;
		}
		
		int rightBound = right.length - 1;
		for(int i = right.length - 1; i > 0; i--) {
			if(matrix[0][i] == '1') {
				rightBound = Math.max(rightBound, i);
				right[i] = rightBound;
				continue;
			}
			rightBound = i - i;
		}
	}
}
