
public class MinimunPathSum {
	public int minPathSum(int[][] grid) {
		/******Using the recursive algorithm, turns out to be out of time limit*********/
		/*findMinPathSum(grid, 0, 0, grid[0][0]);
		return minPathSum;
	}
	
	private void findMinPathSum(int[][] grid, int goDownCount, int goRightCount, int currentSum) {
		if(goRightCount < grid[0].length - 1) {
			findMinPathSum(grid, goDownCount, goRightCount + 1, currentSum + grid[goDownCount][goRightCount + 1]);
		}
		if(goDownCount < grid.length - 1) {
			findMinPathSum(grid, goDownCount + 1, goRightCount, currentSum + grid[goDownCount + 1][goRightCount]);
		}
		if(goDownCount + goRightCount == grid.length + grid[0].length - 2){
			if(currentSum < minPathSum) minPathSum = currentSum;
		}
	
		
	}
	private int minPathSum = Integer.MAX_VALUE;*/
	/*******Use the dynamic programming*********/
		int[][] minNodeSum = new int[grid.length][grid[0].length];
		minNodeSum[0][0] = grid[0][0];
		for(int i = 1; i < grid[0].length; i++) {
			minNodeSum[0][i] = grid[0][i] + minNodeSum[0][i - 1];
		}
		
		for(int i = 1; i < grid.length; i++) {
			minNodeSum[i][0] = grid[i][0] + minNodeSum[i - 1][0];
		}
		
		for(int i = 1; i < grid.length; i++) {
			for(int j = 1; j < grid[0].length; j++) {
				minNodeSum[i][j] = grid[i][j] + Math.min(minNodeSum[i - 1][j], minNodeSum[i][j - 1]);
			}
		}
		
		
		return minNodeSum[grid.length - 1][grid[0].length - 1];
	}
}
