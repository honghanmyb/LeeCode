import java.util.Arrays;

public class SetMatrixZeros {
	public void setZeros(int[][] matrix) {
		int[] rows = new int[matrix.length];
		int[] columns = new int[matrix[0].length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					rows[i] = 1;
					columns[j] = 1;
				}
			}


		}
		
		for(int i = 0; i < rows.length; i++) {
			if(rows[i] == 1) {
				for(int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int j = 0; j < columns.length; j++) {
			if(columns[j] == 1) {
				for(int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
