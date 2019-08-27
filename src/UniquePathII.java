
public class UniquePathII {
	private int totalUniquePaths = 0;
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		findUniquePaths(obstacleGrid, 0, 0);
		return totalUniquePaths;
	}
	
	private void findUniquePaths(int[][] obstacleGrid, int row, int column) {
		if(obstacleGrid[row][column] == 1) {
			return;
		}
		if(row == obstacleGrid.length - 1 && column == obstacleGrid[0].length - 1) {
			totalUniquePaths += 1;
			return;
		}
		if(row < obstacleGrid.length - 1) {
			findUniquePaths(obstacleGrid, row + 1, column);
		}
		if(column < obstacleGrid[0].length - 1) {
			findUniquePaths(obstacleGrid, row, column + 1);
		}
	}
}
