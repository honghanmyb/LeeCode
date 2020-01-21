import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    private int[][] directions = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int shortestDistance(int[][] grid) {
        List<int[]> buildingPoses = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    buildingPoses.add(new int[]{i, j});
                }
            }
        }
        int[][][] dists = new int[grid.length][grid[0].length][2];
        for (int[] buildingPos : buildingPoses) {
            if (!canReach(grid, dists, buildingPos, buildingPoses.size())) {
                return -1;
            }
        }
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && dists[i][j][1] == buildingPoses.size() && dists[i][j][0] > 0) {
                    minDist = Math.min(minDist, dists[i][j][0]);
                }
            }
        }
        return minDist;
    }

    private boolean canReach(int[][] grid, int[][][] dists, int[] buildingPos, int buildingCount) {
        Queue<int[]> queue = new LinkedList<>();
        int[] flag = new int[]{};
        int dist = 1;
        int curBuildingCount = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int[] direction : directions) {
            int nextRow = buildingPos[0] + direction[0];
            int nextColumn = buildingPos[1] + direction[1];
            if (withinRange(nextRow, nextColumn, grid) && grid[nextRow][nextColumn] == 0) {
                queue.add(new int[]{nextRow, nextColumn});
            }
        }
        queue.add(flag);
        while (true) {
            int[] curPos = queue.poll();
            if (curPos == flag) {
                dist++;
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(flag);
                continue;
            }
            if (seen[curPos[0]][curPos[1]]) {
                continue;
            }
            seen[curPos[0]][curPos[1]] = true;
            dists[curPos[0]][curPos[1]][0] += dist;
            dists[curPos[0]][curPos[1]][1]++;
            for (int[] direction : directions) {
                int nextRow = curPos[0] + direction[0];
                int nextColumn = curPos[1] + direction[1];
                if (!withinRange(nextRow, nextColumn, grid)) {
                    continue;
                }
                if (!seen[nextRow][nextColumn] && grid[nextRow][nextColumn] != 2) {
                    if (grid[nextRow][nextColumn] == 1) {
                        seen[nextRow][nextColumn] = true;
                        curBuildingCount++;
                    } else {
                        queue.add(new int[]{nextRow, nextColumn});
                    }
                }
            }
        }
        return curBuildingCount == buildingCount;
    }

    private boolean withinRange(int row, int column, int[][] grid) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }
}
