public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        return Math.max(countOverlap(A, B), countOverlap(B, A));
    }

    private int countOverlap(int[][] move, int[][] still){
        int n = move.length - 1;
        int count = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                count = Math.max(count, getCount(move, still, i, j, n));
            }
        }
        return count;
    }

    private int getCount(int[][] move, int[][] still, int row, int column, int n){
        int count = 0;
        for(int i = 0; i <= row; i++){
            for(int j = 0; j <= column; j++){
                if(move[i][j] == 1 && still[n - row + i][n - column + j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
