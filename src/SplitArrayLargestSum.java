import java.util.PriorityQueue;

public class SplitArrayLargestSum {
	/**
    *	using binary search
    *	basic idea is to first define the max and min possible value of the sum of sub array
    *	then find the middle possible of the sum of sub array
    *	check if the array can be devide into m sub arrays with each sum smaller than middle
    *	if yes, then the middle is too large, make max = middle
    *	if no, then the middle is too small, make min = middle + 1
    *	by doing so on and on, finally will narrow down the min and max value
    *	then return the min value
    **/
    public int splitArray(int[] nums, int m) {
        int minVal = nums[0], maxVal = 0;
        for(int num: nums){
            minVal = Integer.max(minVal, num);
            maxVal += num;
        }
        if(m == 1){
            return maxVal;
        }
        if(maxVal < 0){
            return Integer.MAX_VALUE;
        }
        
        while(minVal <= maxVal){
            int middle = minVal + (maxVal - minVal) / 2;
            if(canSplit(middle, nums, m)){
                maxVal = middle - 1;
            }else{
                minVal = middle + 1;
            }
        }
        
        return minVal;
    }
    
    private boolean canSplit(int target, int[] nums, int m){
        int currentSum = 0;
        for(int num: nums){
            currentSum += num;
            if(currentSum > target){
                currentSum = num;
                m -= 1;
                if(m <= 0){
                    return false;
                }
            }
        }
        return true;
    }
	
//    public int splitArray(int[] nums, int m) {
//        int[][] minMaxSum = new int[m][nums.length];
//        minMaxSum[0][0] = nums[0];
//        for(int i = 1; i < nums.length; i++){
//            minMaxSum[0][i] = nums[i] + minMaxSum[0][i - 1];
//            if(minMaxSum[0][i] < 0){
//                return Integer.MAX_VALUE;
//            }
//        }
//        for(int i = 1; i < m; i++){
//            for(int j = 0; j < nums.length; j++){
//                if(j < i){
//                    minMaxSum[i][j] = Integer.MAX_VALUE;
//                    continue;
//                }
//                int minMax = minMaxSum[0][j];
//                int currentMinMax = minMax;
//                for(int k = 0; k <= j; k++){
//                    currentMinMax -= nums[k];
//                    int currentMax = Integer.max(minMaxSum[i - 1][k], currentMinMax);
//                    minMax = Integer.min(minMax, currentMax);
//                }
//                minMaxSum[i][j] = minMax;
//            }
//        }
//        return minMaxSum[m - 1][nums.length - 1];
//    }
}
