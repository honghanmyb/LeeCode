
public class MaxSubarray {
	public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            maxSum = Integer.max(maxSum, currentSum);
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
	}
}
