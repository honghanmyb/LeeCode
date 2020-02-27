public class UniquePathsIII {
    private int pathNum;
    private int[][] directions = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    public int uniquePathsIII(int[][] grid) {
        pathNum = 0;
        int emptyCount = 0;
        int startRow = 0, startCol = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    startRow = i;
                    startCol = j;
                    grid[i][j] = 0;
                }
                if(grid[i][j] == 0){
                    emptyCount++;
                }
            }
        }
        findPaths(grid, startRow, startCol, emptyCount);
        return pathNum;
    }

    private void findPaths(int[][] grid, int curRow, int curCol, int emptyCount){
        if(curRow < 0 || curRow >= grid.length || curCol < 0 || curCol >= grid[0].length){
            return;
        }
        if(grid[curRow][curCol] == -1 || grid[curRow][curCol] == 1){
            return;
        }
        if(grid[curRow][curCol] == 2){
            if(emptyCount == 0){
                ++pathNum;
            }
            return;
        }
        grid[curRow][curCol] = 1;
        for(int[] direction : directions){
            findPaths(grid, curRow + direction[0], curCol + direction[1], emptyCount - 1);
        }
        grid[curRow][curCol] = 0;
    }
}
