public class ShortestPathWithObstacleElimination {
    private int minStep = Integer.MAX_VALUE;
    private int[][] nextSteps = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int shortestPath(int[][] grid, int k) {
        if (k >= grid.length + grid[0].length - 2) {
            return grid.length + grid[0].length - 2;
        }
        int[][] minObstacles = new int[grid.length][grid[0].length];
        minObstacles[0][0] = 0;
        for (int i = 1; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                minObstacles[0][i] = 1 + minObstacles[0][i - 1];
            } else {
                minObstacles[0][i] = minObstacles[0][i - 1];
            }
        }
        for (int j = 1; j < grid.length; j++) {
            if (grid[j][0] == 1) {
                minObstacles[j][0] = 1 + minObstacles[j - 1][0];
            } else {
                minObstacles[j][0] = minObstacles[j - 1][0];
            }
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                int temp = Math.min(minObstacles[i - 1][j], minObstacles[i][j - 1]);
                minObstacles[i][j] = grid[i][j] == 1 ? 1 + temp : temp;
            }
        }
        if (minObstacles[grid.length - 1][grid[0].length - 1] <= k) {
            return grid.length + grid[0].length - 2;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        findPath(grid, k, 0, visited, 0, 0);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    private void findPath(int[][] grid, int kLeft, int currentStep, boolean[][] visited, int row, int column) {
        if (currentStep >= minStep) {
            return;
        }
        if (row == grid.length - 1 && column == grid[0].length - 1) {
            minStep = Math.min(currentStep, minStep);
            return;
        }
        for (int[] nextStep : nextSteps) {
            int newRow = row + nextStep[0];
            int newColumn = column + nextStep[1];
            if (newRow >= 0 && newRow < grid.length && newColumn >= 0 && newColumn < grid[0].length) {
                if (!visited[newRow][newColumn]) {
                    if (grid[newRow][newColumn] == 1 && kLeft == 0) {
                        continue;
                    }
                    visited[newRow][newColumn] = true;
                    findPath(grid, grid[newRow][newColumn] == 1 ? kLeft - 1 : kLeft, currentStep + 1, visited, newRow, newColumn);
                    visited[newRow][newColumn] = false;
                }
            }
        }
    }
}
