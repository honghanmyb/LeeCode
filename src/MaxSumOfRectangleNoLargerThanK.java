public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] table = new int[matrix.length][matrix[0].length];
        int sum = 0;
        for(int i = 0; i < matrix[0].length; i++){
            sum += matrix[0][i];
            table[0][i] = sum;
        }
        sum = 0;
        for(int j = 0; j < matrix.length; j++){
            sum += matrix[j][0];
            table[j][0] = sum;
            if(sum == k){
                return k;
            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                table[i][j] = table[i - 1][j] + table[i][j - 1] - table[i - 1][j - 1] + matrix[i][j];
                if(table[i][j] == k){
                    return k;
                }
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                maxSum = Math.max(maxSum, maxSumAtIndex(i, j, table, k));
                if(maxSum == k){
                    return k;
                }
            }
        }
        return maxSum;
    }

    private int maxSumAtIndex(int row, int column, int[][] table, int k){
        int currentMax = Integer.MIN_VALUE;
        for(int i = 0; i <= row; i++){
            for(int j = 0; j <= column; j++){
                int recSum = getSumAtIndex(i, j, row, column, table);
                if(recSum <= k){
                    currentMax = Math.max(currentMax, recSum);
                }
            }
        }
        return currentMax;
    }

    private int getSumAtIndex(int topX, int topY, int bottomX, int bottomY, int[][] table){
        if(topX == 0 && topY == 0){
            return table[bottomX][bottomY];
        }
        if(topX == 0){
            return table[bottomX][bottomY] - table[bottomX][topY - 1];
        }
        if(topY == 0){
            return table[bottomX][bottomY] - table[topX - 1][bottomY];
        }
        return table[bottomX][bottomY] - table[bottomX][topY - 1] - table[topX - 1][bottomY]
                + table[topX - 1][topY - 1];
    }
}
