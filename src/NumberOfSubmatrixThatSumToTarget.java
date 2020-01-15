public class NumberOfSubmatrixThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] matrixSum = new int[matrix.length][matrix[0].length];
        matrixSum[0][0] = matrix[0][0];
        for(int j = 1; j < matrix[0].length; j++){
            matrixSum[0][j] = matrix[0][j] + matrixSum[0][j - 1];
        }
        for(int i = 1; i < matrix.length; i++){
            matrixSum[i][0] = matrix[i][0] + matrixSum[i - 1][0];
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                matrixSum[i][j] = matrixSum[i - 1][j] + matrixSum[i][j - 1] - matrixSum[i - 1][j - 1] + matrix[i][j];
            }
        }
        int submatrixCount = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int count = countSubmatrix(matrixSum, i, j, target);
                submatrixCount += count;
            }
        }
        return submatrixCount;
    }

    private int countSubmatrix(int[][] matrixSum, int xLimit, int yLimit, int target){
        int count = 0;
        for(int i = 0; i <= xLimit; i++){
            for(int j = 0; j <= yLimit; j++){
                if(getSum(matrixSum, i, j, xLimit, yLimit) == target){
                    ++count;
                }
            }
        }
        return count;
    }

    private int getSum(int[][] matrixSum, int x1, int y1, int x2, int y2){
        if(x1 + y1 == 0){
            return matrixSum[x2][y2];
        }
        if(x1 == 0){
            return matrixSum[x2][y2] - matrixSum[x2][y1 - 1];
        }
        if(y1 == 0){
            return matrixSum[x2][y2] - matrixSum[x1 - 1][y2];
        }
        return matrixSum[x2][y2] - matrixSum[x2][y1 - 1] - matrixSum[x1 - 1][y2] + matrixSum[x1 - 1][y1 - 1];
    }
}
