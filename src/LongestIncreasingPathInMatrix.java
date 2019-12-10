import java.util.LinkedList;
import java.util.Queue;

public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int[][] table = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                table[i][j] = calculate(matrix, i, j);
                if (table[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[] flag = new int[0];
        queue.add(flag);
        while (true) {
            int[] current = queue.poll();
            if (current == flag) {
                count++;
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(flag);
                continue;
            }
            addNextPoints(queue, matrix, table, current[0], current[1]);
        }
        return count;
    }

    private void addNextPoints(Queue<int[]> queue, int[][] matrix, int[][] table, int row, int column) {
        int current = matrix[row][column];
        if (row > 0 && matrix[row - 1][column] > current) {
            table[row - 1][column]--;
            if (table[row - 1][column] == 0) {
                queue.add(new int[]{row - 1, column});
            }
        }
        if (row < matrix.length - 1 && matrix[row + 1][column] > current) {
            table[row + 1][column]--;
            if (table[row + 1][column] == 0) {
                queue.add(new int[]{row + 1, column});
            }
        }
        if (column > 0 && matrix[row][column - 1] > current) {
            table[row][column - 1]--;
            if (table[row][column - 1] == 0) {
                queue.add(new int[]{row, column - 1});
            }
        }
        if (column < matrix[0].length - 1 && matrix[row][column + 1] > current) {
            table[row][column + 1]--;
            if (table[row][column + 1] == 0) {
                queue.add(new int[]{row, column + 1});
            }
        }
    }

    private int calculate(int[][] matrix, int row, int column) {
        int current = matrix[row][column];
        int count = 0;
        if (row > 0 && matrix[row - 1][column] < current) {
            count++;
        }
        if (row < matrix.length - 1 && matrix[row + 1][column] < current) {
            count++;
        }
        if (column > 0 && matrix[row][column - 1] < current) {
            count++;
        }
        if (column < matrix[0].length - 1 && matrix[row][column + 1] < current) {
            count++;
        }
        return count;
    }
}
