import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumCostToMakeAtLeastOneValidPathInAGrid {
    // 1 -> go right
    // 2 -> go left
    // 3 -> go down
    // 4 -> go up
    public int minCost(int[][] grid) {
        int[][] costs = new int[grid.length][grid[0].length];
        int[][] directions = new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        for (int[] cost : costs) {
            Arrays.fill(cost, Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        costs[costs.length - 1][costs[0].length - 1] = 0;
        queue.add(new int[]{costs.length - 1, costs[0].length - 1});
        while (!queue.isEmpty()) {
            int[] updatedCell = queue.poll();
            for (int[] direction : directions) {
                int newRow = updatedCell[0] + direction[0];
                int newCol = updatedCell[1] + direction[1];
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) continue;
                int newCost = getCost(grid, newRow, newCol, updatedCell[0], updatedCell[1], costs[updatedCell[0]][updatedCell[1]]);
                if (newCost < costs[newRow][newCol]) {
                    costs[newRow][newCol] = newCost;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
        return costs[0][0];
    }

    private int getCost(int[][] grid, int newRow, int newCol, int oldRow, int oldCol, int cost) {
        int nextRow = newRow, nextCol = newCol;
        switch (grid[newRow][newCol]) {
            case 1: {
                ++nextCol;
                break;
            }
            case 2: {
                --nextCol;
                break;
            }
            case 3: {
                ++nextRow;
                break;
            }
            case 4: {
                --nextRow;
                break;
            }
            default: {
            }
        }
        return nextRow == oldRow && nextCol == oldCol ? cost : cost + 1;
    }
}
