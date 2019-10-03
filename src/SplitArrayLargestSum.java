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
    
    /**
     *	using binary search
     *	basic idea is to first define the max and min possible value of the sum of sub array
     *	then find the middle possible of the sum of sub array
     *	check if the array can be devide into m sub arrays with each sum smaller than middle
     *	if yes, then the middle is too large, make max = middle
     *	if no, then the middle is too small, make min = middle + 1
     *	by doing so on and on, finally will narrow down the min and max value
     *	then return the min value
     *     public int splitArray(int[] nums, int m) {

        int minVal = Integer.MIN_VALUE, maxVal = 0;
        for (int num : nums) {
            minVal = Math.max(minVal, num);
            maxVal += num;
        }

        while (minVal < maxVal) {
            int mid = minVal + (maxVal - minVal) / 2;
            if (canSplit(mid, nums, m)) {
                maxVal = mid;
            } else {
                minVal = mid + 1;
            }
        }

        return minVal;
    }

    private boolean canSplit(int upperBoundSubarraySum, int[] nums, int m) {

        int curSubarraySum = 0, cntSubarray = 1;
        for (int num : nums) {
            curSubarraySum += num;
            if (curSubarraySum > upperBoundSubarraySum) {
                cntSubarray++;
                curSubarraySum = num;
                if (cntSubarray > m) {
                    return false;
                }
            }
        }

        return true;
    }
     */
}
