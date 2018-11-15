
public class SpiralMatrixII {
	public int[][] generateMatrix(int n){
		int[][] spiralMat = new int[n][n];
		int num = 1;
		for(int i = 0; i < (n + 1)/2; i++) {
			for(int j = i; j < n - 1 - i;j++) {
				spiralMat[i][j] = num;
				spiralMat[j][n-1-i] = num + n - 1 - 2 *i;
				spiralMat[n - 1 - i][n - 1 - j] = num + 2*n - 2 - 4 *i;
				spiralMat[n - 1 - j][i] = num  + 3*n - 3 - 6 *i ;
				num++;
			}
			num = num +  3 * n - 3 - 6*i;
			
		}
		if(n % 2 == 1) {
			spiralMat[n/2][n/2] = n*n;
		}
		return spiralMat;
	}
}
