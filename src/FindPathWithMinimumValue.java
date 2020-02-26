public class FindPathWithMinimumValue {
    public int maximumMinimumPath(int[][] A) {
        int max = Math.min(A[0][0], A[A.length - 1][A[0].length - 1]);
        int min = 0;
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(canFindPath(A, new boolean[A.length][A[0].length], 0, 0, mid)){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }
        return min - 1;
    }

    private boolean canFindPath(int[][] A, boolean[][] used, int curRow, int curCol, int minScore){
        if(curRow < 0 || curRow >= A.length || curCol < 0 || curCol >= A[0].length){
            return false;
        }
        if(used[curRow][curCol] || A[curRow][curCol] < minScore){
            return false;
        }
        if(curRow == A.length - 1 && curCol == A[0].length - 1){
            return true;
        }
        used[curRow][curCol] = true;
        return canFindPath(A, used, curRow + 1, curCol, minScore) || canFindPath(A, used, curRow, curCol + 1, minScore) || canFindPath(A, used, curRow - 1, curCol, minScore) || canFindPath(A, used, curRow, curCol - 1, minScore);
    }
}
