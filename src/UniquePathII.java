
public class UniquePathII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];
		boolean canReach = true;
		for(int i = 0; i < paths.length; i++) {
			if(canReach) {
				if(obstacleGrid[i][0] == 0) {
					paths[i][0] = 1;
				}else {
					paths[i][0] = 0;
					canReach = false;
				}
			}
		}
		canReach = true;
		for(int j = 0; j < paths[0].length; j++) {
			if(canReach) {
				if(obstacleGrid[0][j] == 0) {
					paths[0][j] = 1;
				}else {
					paths[0][j] = 0;
					canReach = false;
				}
			}
		}
		for(int i = 1; i < paths.length; i++) {
			for(int j = 1; j < paths[0].length; j++) {
				if(obstacleGrid[i][j] == 1) {
					paths[i][j] = 0;
				}else {
					paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
				}
			}
		}
		return paths[paths.length - 1][paths[0].length - 1];
	}
}
