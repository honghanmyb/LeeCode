import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CountSquareSubmatrixFillWithOne {
    public int countSquares(int[][] matrix) {
        List<TreeSet<Integer>> zeroPoses = new ArrayList<>(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            zeroPoses.add(new TreeSet<>());
        }
        int count1 = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroPoses.get(i).add(j);
                    count1++;
                }
            }
        }
        int count = matrix.length * matrix[0].length - count1;
        int largestSide = Math.min(matrix.length, matrix[0].length);
        for (int side = 2; side <= largestSide; side++) {
            for (int i = 0; i <= matrix.length - side; i++) {
                for (int j = 0; j <= matrix[0].length - side; j++) {
                    if (isFill(i, j, i + side - 1, j + side - 1, zeroPoses)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isFill(int leftTopX, int leftTopY, int rightBottomX, int rightBottomY, List<TreeSet<Integer>> zeroPoses) {
        for (int i = leftTopX; i <= rightBottomX; i++) {
            TreeSet<Integer> yPos = zeroPoses.get(i);
            Integer ceiling = yPos.ceiling(leftTopY);
            if (ceiling != null && ceiling <= rightBottomY) {
                return false;
            }
            Integer floor = yPos.floor(rightBottomY);
            if (floor != null && floor >= leftTopY) {
                return false;
            }
        }
        return true;
    }
}
