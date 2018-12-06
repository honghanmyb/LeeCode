
public class NumOfIslands {
	public int numIslands(char[][] grid) {
		boolean[][] isSearched = new boolean[grid.length][grid[0].length];
		int count = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == '1' && !isSearched[i][j]) {
					dfs(grid, isSearched, i, j);
					count++;
				}
			}
		}
		return count;
	}
	
	private void dfs(char[][] grid, boolean[][] isSearched, int row, int col) {
		if(isSearched[row][col]) return;
		isSearched[row][col] = true;
		if(row < grid.length - 1 && grid[row + 1][col] == '1') dfs(grid, isSearched, row + 1, col);
		if(row > 0 && grid[row - 1][col] == '1') dfs(grid, isSearched, row - 1, col);
		if(col > 0 && grid[row][col - 1] == '1') dfs(grid, isSearched, row, col - 1);
		if(col < grid[0].length - 1 && grid[row][col + 1] == '1') dfs(grid, isSearched, row, col +  1);
	}
}
