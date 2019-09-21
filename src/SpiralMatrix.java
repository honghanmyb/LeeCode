import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix){
		List<Integer> spiralOrderList = new ArrayList<>();
		if(matrix.length == 0) {
			return spiralOrderList;
		}
		addMatrixElementAmongFourCorners(matrix, 0, 0, matrix[0].length - 1,
				matrix.length - 1, 0, matrix[matrix.length - 1].length - 1, spiralOrderList);
		return spiralOrderList;
	}
	
	private void addMatrixElementAmongFourCorners(int[][] matrix, int topX, int topLeft, int topRight, int bottomX, 
			int bottomLeft, int bottomRight, List<Integer> spiralOrderList) {
		if(topX == bottomX) {
			for(int i = topLeft; i <= topRight; i++) {
				spiralOrderList.add(matrix[topX][i]);
			}
			return;
		}
		if(topLeft == topRight) {
			for(int i = topX; i <= bottomX; i++) {
				spiralOrderList.add(matrix[i][topLeft]);
			}
			return;
		}
		if(topX > bottomX) {
			return;
		}
        if(topLeft > topRight){
            return;
        }
		for(int i = topLeft; i < topRight; i++) {
			spiralOrderList.add(matrix[topX][i]);
		}
		for(int i = topX; i < bottomX; i++) {
			spiralOrderList.add(matrix[i][topRight]);
		}
		for(int i = bottomRight; i > bottomLeft; i--) {
			spiralOrderList.add(matrix[bottomX][i]);
		}
		for(int i = bottomX; i > topX; i--) {
			spiralOrderList.add(matrix[i][bottomLeft]);
		}
		addMatrixElementAmongFourCorners(matrix, topX + 1, topLeft + 1, topRight - 1, bottomX - 1, 
				bottomLeft + 1, bottomRight - 1, spiralOrderList);
	}
}
