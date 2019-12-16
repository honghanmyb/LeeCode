public class MaxSideLength {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] table = new int[m][n];
        table[0][0] = mat[0][0];
        for(int i = 1; i < m; i++){
            table[i][0] = mat[i][0] + table[i - 1][0];
        }
        for(int i = 1; i < n; i++){
            table[0][i] = mat[0][i] + table[0][i - 1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                table[i][j] = mat[i][j] + table[i - 1][j] + table[i][j - 1] - table[i - 1][j - 1];
            }
        }
        int maxLength = Math.min(m, n);
        while(maxLength > 0){
            if(isSatisfy(maxLength, table, threshold)){
                return maxLength;
            }
            maxLength--;
        }

        return maxLength;
    }

    private boolean isSatisfy(int length, int[][] table, int threshold){
        if(table[length - 1][length - 1] <= threshold){
            return true;
        }
        for(int j = length; j < table[0].length; j++){
            if(table[length - 1][j] - table[length - 1][j - length] <= threshold){
                return true;
            }
        }
        for(int i = length; i < table.length; i++){
            if(table[i][length - 1] - table[i - length][length - 1] <= threshold){
                return true;
            }
        }
        for(int i = length; i < table.length; i++){
            for(int j = length; j < table[0].length; j++){
                if(table[i][j] - table[i - length][j] - table[i][j - length] + table[i - length][j - length] <= threshold){
                    return true;
                }
            }
        }
        return false;
    }
}
