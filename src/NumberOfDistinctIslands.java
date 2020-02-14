import java.util.ArrayList;
import java.util.List;

public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        List<int[]> islandStartIndex = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int[] curStartIndex = new int[]{i, j};
                    markIsland(i, j, grid, visited, directions);
                    boolean isDistinct = true;
                    for(int[] startIndex : islandStartIndex){
                        if(isSameIsland(i, j, startIndex[0], startIndex[1], grid, directions, new boolean[grid.length][grid[0].length])){
                            isDistinct = false;
                            break;
                        }
                    }
                    if(isDistinct){
                        islandStartIndex.add(curStartIndex);
                    }
                }
            }
        }
        return islandStartIndex.size();
    }

    private void markIsland(int row, int column, int[][] grid, boolean[][] visited, int[][] directions){
        visited[row][column] = true;
        for(int[] direction : directions){
            int newRow = row + direction[0];
            int newColumn = column + direction[1];
            if(newRow >= 0 && newRow < grid.length && newColumn >= 0 && newColumn < grid[0].length && grid[newRow][newColumn] == 1 && visited[newRow][newColumn] == false){
                markIsland(newRow, newColumn, grid, visited, directions);
            }
        }
    }

    private boolean isSameIsland(int aRow, int aCol, int bRow, int bCol, int[][] grid, int[][] directions, boolean[][] visited){
        visited[aRow][aCol] = true;
        visited[bRow][bCol] = true;
        for(int[] direction : directions){
            int newARow = aRow + direction[0];
            int newACol = aCol + direction[1];
            int newBRow = bRow + direction[0];
            int newBCol = bCol + direction[1];
            boolean newAValid = isPointValid(newARow, newACol, grid, visited);
            boolean newBValid = isPointValid(newBRow, newBCol, grid, visited);
            if(!newAValid && !newBValid){
                continue;
            }
            if(newAValid && !newBValid || !newAValid && newBValid){
                return false;
            }
            if(newAValid && newBValid){
                if(!isSameIsland(newARow, newACol, newBRow, newBCol, grid, directions, visited)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPointValid(int row, int col, int[][] grid, boolean[][] visited){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1 && !visited[row][col];
    }
}
