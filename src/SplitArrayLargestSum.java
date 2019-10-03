import java.util.PriorityQueue;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int[][] minMaxSum = new int[m][nums.length];
        minMaxSum[0][0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            minMaxSum[0][i] = nums[i] + minMaxSum[0][i - 1];
            if(minMaxSum[0][i] < 0){
                return Integer.MAX_VALUE;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < nums.length; j++){
                if(j < i){
                    minMaxSum[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                int minMax = minMaxSum[0][j];
                int currentMinMax = minMax;
                for(int k = 0; k <= j; k++){
                    currentMinMax -= nums[k];
                    int currentMax = Integer.max(minMaxSum[i - 1][k], currentMinMax);
                    minMax = Integer.min(minMax, currentMax);
                }
                minMaxSum[i][j] = minMax;
            }
        }
        return minMaxSum[m - 1][nums.length - 1];
    }
}
