import java.util.ArrayList;
import java.util.List;

public class LongestLineOfConsecutiveOneInMatrix {
    public int longestLine(int[][] M) {
        //directions row, column, diagonal, anti-diagonal
        if(M.length < 1 || M[0].length < 1){
            return 0;
        }
        List<int[]> startPoints = new ArrayList<>();
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                if(M[i][j] == 1){
                    if(j == 0 || M[i][j - 1] == 0){
                        startPoints.add(new int[]{i, j, 0, 1});
                    }
                    if(i == 0 || M[i - 1][j] == 0){
                        startPoints.add(new int[]{i, j, 1, 0});
                    }
                    if(i == 0 || j == 0 || M[i - 1][j - 1] == 0){
                        startPoints.add(new int[]{i, j, 1, 1});
                    }
                    if(i == 0 || j == M[0].length - 1 || M[i - 1][j + 1] == 0){
                        startPoints.add(new int[]{i, j, 1, -1});
                    }
                }
            }
        }
        int longest = 0;
        for(int[] startPoint : startPoints){
            longest = Math.max(longest, getLineLength(M, startPoint[0], startPoint[1], startPoint[2], startPoint[3]));
        }
        return longest;
    }

    private int getLineLength(int[][] M, int rowIndex, int columnIndex, int rowIncrement, int columnIncrement){
        if(rowIndex < 0 || rowIndex >= M.length){
            return 0;
        }
        if(columnIndex < 0 || columnIndex >= M[0].length){
            return 0;
        }
        if(M[rowIndex][columnIndex] == 0){
            return 0;
        }
        return 1 + getLineLength(M, rowIndex + rowIncrement, columnIndex + columnIncrement, rowIncrement, columnIncrement);
    }
}
