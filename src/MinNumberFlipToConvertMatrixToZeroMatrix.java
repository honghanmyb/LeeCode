import java.util.HashSet;
import java.util.Set;

public class MinNumberFlipToConvertMatrixToZeroMatrix {
    int minCount = -1;
    public int minFlips(int[][] mat) {
        Set<Integer> status = new HashSet<>();
        int initialStatus = getStatus(mat);
        if(initialStatus == 0){
            return 0;
        }
        status.add(initialStatus);
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                findMinFlip(mat, status, 0, i, j);
            }
        }
        return minCount;
    }

    private void findMinFlip(int[][] mat, Set<Integer> status, int preCount, int row, int column){
        if(minCount != -1 && minCount <= preCount){
            return;
        }
        flip(mat, row, column);
        int curStatus = getStatus(mat);
        if(curStatus == 0){
            minCount = minCount == -1? preCount + 1 : Math.min(preCount + 1, minCount);
            flip(mat, row, column);
            return;
        }
        for(int j = column + 1; j < mat[0].length; j++){
            findMinFlip(mat, status, preCount + 1, row, j);
        }
        for(int i = row + 1; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                findMinFlip(mat, status, preCount + 1, i, j);
            }
        }
        flip(mat, row, column);
    }

    private void flip(int[][] mat, int row, int column){
        mat[row][column] = flipElement(mat[row][column]);
        if(row > 0){
            mat[row - 1][column] = flipElement(mat[row - 1][column]);
        }
        if(row < mat.length - 1){
            mat[row + 1][column] = flipElement(mat[row + 1][column]);
        }
        if(column > 0){
            mat[row][column - 1] = flipElement(mat[row][column - 1]);
        }
        if(column < mat[0].length - 1){
            mat[row][column + 1] = flipElement(mat[row][column + 1]);
        }
    }

    private int flipElement(int element){
        return element == 1? 0 : 1;
    }

    private int getStatus(int[][] mat){
        int status = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                status *= 10;
                status += mat[i][j];
            }
        }
        return status;
    }
}
