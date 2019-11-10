
public class CellsWithOddValueInMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for(int[] indice: indices){
            int row = indice[0];
            int column = indice[1];
            for(int i = 0; i < m; i++){
                matrix[row][i]++;
            }
            for(int i = 0; i < n; i++){
                matrix[i][column]++;
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] % 2 == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
