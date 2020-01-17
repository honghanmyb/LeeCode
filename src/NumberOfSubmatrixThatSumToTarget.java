import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatrixThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] columnSum = new int[matrix.length + 1][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                columnSum[i + 1][j] = columnSum[i][j] + matrix[i][j];
            }
        }
        int count = 0;
        for (int startRow = 1; startRow < columnSum.length; startRow++) {
            for (int endRow = startRow; endRow < columnSum.length; endRow++) {
                Map<Integer, Integer> sumToOccurTimes = new HashMap<>();
                int curSum = 0;
                for (int j = 0; j < columnSum[0].length; j++) {
                    curSum += columnSum[endRow][j] - columnSum[startRow - 1][j];
                    if (curSum == target) {
                        ++count;
                    }
                    if (sumToOccurTimes.containsKey(curSum - target)) {
                        count += sumToOccurTimes.get(curSum - target);
                    }
                    if (sumToOccurTimes.containsKey(curSum)) {
                        sumToOccurTimes.put(curSum, sumToOccurTimes.get(curSum) + 1);
                    } else {
                        sumToOccurTimes.put(curSum, 1);
                    }
                }
            }
        }
        return count;
    }
}
