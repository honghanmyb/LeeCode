
public class NumbersOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int total = 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for(int i = 1; i < grid.length - 1; i++){
            for(int j = 1; j < grid[0].length - 1; j++){
                if(grid[i][j] == 1){
                    continue;
                }
                if(visit[i][j]){
                    continue;
                }
                total += search(i, j, grid, visit)? 1: 0;
            }
        }
        return total;
    }
    
    private boolean search(int row, int column, int[][] grid, boolean[][] visit){
        // System.out.println(visit[row][column]);
        visit[row][column] = true;
        boolean isClose = true;
        // System.out.println("row " + row + ", column: " + column);
        if(row == 0 || row == grid.length - 1 || column == 0 || column == grid[0].length - 1){
            return false;
        }
        if(grid[row - 1][column] == 0 && visit[row - 1][column] == false){
            if(search(row - 1, column, grid, visit) == false){
                isClose = false;
            }
        }
        if(grid[row + 1][column] == 0 && visit[row + 1][column] == false){
            if(search(row + 1, column, grid, visit) == false){
                isClose = false;
            }
        }
        if(grid[row][column - 1] == 0 && visit[row][column - 1] == false){
            if(search(row, column - 1, grid, visit) == false){
                isClose = false;
            }
        }
        if(grid[row][column + 1] == 0 && visit[row ][column + 1] == false){
            if(search(row , column + 1, grid, visit) == false){
                isClose = false;
            }
        }
        return isClose;
    }
}
