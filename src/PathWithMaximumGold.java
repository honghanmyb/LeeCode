import java.util.ArrayList;
import java.util.List;

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        boolean[][] hasUsed = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    max = Math.max(max, findMax(grid, i, j, hasUsed));
                }
            }
        }
        return max;
    }
    private int findMax(int[][] grid, int row, int column, boolean[][] hasUsed){
        hasUsed[row][column] = true;
        int current = grid[row][column];
        int max = 0;
        if(row > 0 && grid[row - 1][column] > 0 && !hasUsed[row - 1][column]){
            max = Math.max(max, findMax(grid, row - 1, column, hasUsed));
        }
        if(row < grid.length - 1 && grid[row + 1][column] > 0 && !hasUsed[row + 1][column]){
            max = Math.max(max, findMax(grid, row + 1, column, hasUsed));
        }
        if(column > 0 && grid[row][column - 1] > 0 && !hasUsed[row][column - 1]){
            max = Math.max(max, findMax(grid, row, column - 1, hasUsed));
        }
        if(column < grid[0].length - 1 && grid[row][column + 1] > 0 && !hasUsed[row][column + 1]){
            max = Math.max(max, findMax(grid, row, column + 1, hasUsed));
        }
        hasUsed[row][column] = false;
        return current + max;
    }
}
