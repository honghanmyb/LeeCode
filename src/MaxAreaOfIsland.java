import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int maxArea = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isSearched = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && isSearched[i][j] == false){
                    maxArea = Integer.max(maxArea, findArea(i, j, grid, isSearched, queue));
                }
            }
        }
        return maxArea;
    }
    
    private int findArea(int i, int j, int[][] grid, boolean[][] isSearched, Queue<int[]> queue){
        int area = 0;
        queue.add(new int[]{i, j});
        isSearched[i][j] = true;
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            area += 1;
            if(point[0] > 0 && grid[point[0] - 1][point[1]] == 1 && !isSearched[point[0] - 1][point[1]]){
                queue.add(new int[]{point[0] - 1, point[1]});
                isSearched[point[0] - 1][point[1]] = true;
            }
            if(point[0] < grid.length - 1 && grid[point[0] + 1][point[1]] == 1 
            		&& !isSearched[point[0] + 1][point[1]]){
                queue.add(new int[]{point[0] + 1, point[1]});
                isSearched[point[0] + 1][point[1]] = true;
            }
            if(point[1] > 0 && grid[point[0]][point[1] - 1] == 1 && !isSearched[point[0]][point[1] - 1]){
                queue.add(new int[]{point[0], point[1] - 1});
                isSearched[point[0]][point[1] - 1] = true;
            }
            if(point[1] < grid[0].length - 1 && grid[point[0]][point[1] + 1] == 1
            		&& !isSearched[point[0]][point[1] + 1]){
                queue.add(new int[]{point[0], point[1] + 1});
                isSearched[point[0]][point[1] + 1] = true;
            }
        }
        return area;
    }
}
