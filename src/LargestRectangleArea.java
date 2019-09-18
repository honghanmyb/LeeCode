
public class LargestRectangleArea {
	public int largestRectangleArea(int[] heights) {
		if(heights.length == 0) {
			return 0;
		}
		if(heights.length == 1) {
			return heights[0];
		}
		int[] left = new int[heights.length];
		int[] right = new int[heights.length];
		int minHeight = heights[heights.length - 1];
		for(int i = right.length - 1; i >= 0; i--) {
			if(heights[i] <= minHeight) {
				right[i] = right.length - 1;
				minHeight = heights[i];
			}else {
				for(int j = i; i < right.length; j++) {
					if(heights[j] < heights[i]) {
						right[i] = j - 1;
						break;
					}
				}
			}
		}
		minHeight = heights[0];
		int maxArea = 0;
		for(int i = 0; i < left.length; i++) {
			if(heights[i] <= minHeight) {
				left[i] = 0;
				minHeight = heights[i];
			}else {
				for(int j = i; j >= 0; j--) {
					if(heights[j] < heights[i]) {
						left[i] = j + 1;
						break;
					}
				}
			}
			maxArea = Math.max(maxArea, (right[i] - left[i] + 1) * heights[i]);
		}
		return maxArea;
	}
}
