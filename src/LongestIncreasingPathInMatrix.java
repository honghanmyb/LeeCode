import java.util.Arrays;

public class LongestIncreasingPathInMatrix {
    private int maxPath = 1;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] table = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < table.length; i++){
            Arrays.fill(table[i], 1);
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                findPath(matrix, table, i, j);
            }
        }
        return maxPath;
    }

    private void findPath(int[][] matrix, int[][] table, int row, int column){
        if(row > 0 && matrix[row - 1][column] > matrix[row][column]){
            table[row][column] = Math.max(table[row][column], table[row - 1][column] + 1);
        }
        if(row < matrix.length - 1 && matrix[row + 1][column] > matrix[row][column]){
            table[row][column] = Math.max(table[row][column], table[row + 1][column] + 1);
        }
        if(column > 0 && matrix[row][column - 1] > matrix[row][column]){
            table[row][column] = Math.max(table[row][column], table[row][column - 1] + 1);
        }
        if(column < matrix[0].length - 1 && matrix[row][column + 1] > matrix[row][column]){
            table[row][column] = Math.max(table[row][column], table[row][column + 1] + 1);
        }
        update(matrix, table, row, column);
    }

    private void update(int[][] matrix, int[][] table, int row, int column){
        maxPath = Math.max(maxPath, table[row][column]);
        int possiblePath = table[row][column] + 1;
        if(row > 0 && matrix[row - 1][column] < matrix[row][column] && table[row - 1][column] < possiblePath){
            table[row - 1][column] = possiblePath;
            update(matrix,table, row - 1, column);
        }
        if(row < matrix.length - 1 && matrix[row + 1][column] < matrix[row][column] && table[row + 1][column] < possiblePath){
            table[row + 1][column] = possiblePath;
            update(matrix,table, row + 1, column);
        }
        if(column > 0 && matrix[row][column - 1] < matrix[row][column] && table[row][column - 1] < possiblePath){
            table[row][column - 1] = possiblePath;
            update(matrix,table, row, column - 1);
        }
        if(column < matrix[0].length - 1 && matrix[row][column + 1] < matrix[row][column] && table[row][column + 1] < possiblePath){
            table[row][column + 1] = possiblePath;
            update(matrix,table, row, column + 1);
        }
    }
}
