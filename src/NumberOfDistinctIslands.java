import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Set<List<Integer>> islandShapes = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    List<Integer> shape = new ArrayList<>();
                    markIsland(i, j, grid, visited, directions, shape, 0);
                    islandShapes.add(shape);
                }
            }
        }
        return islandShapes.size();
    }

    private void markIsland(int row, int column, int[][] grid, boolean[][] visited, int[][] directions, List<Integer> shape, int shapeCode){
        if(row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && grid[row][column] == 1 && visited[row][column] == false){
            shape.add(shapeCode);
            visited[row][column] = true;
            for(int i = 0; i < directions.length; i++){
                markIsland(row + directions[i][0], column + directions[i][1], grid, visited, directions, shape, i + 1);
            }
            shape.add(-1);
        }
    }
}
