
public class MaxSubarray {
	public int maxSubArray(int[] nums) {
		int result = nums[0] ;int max = nums[0] ;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > 0) {
				result = max= 0;
				for(int j = 0; j < nums.length; j++) {
					if(result + nums[j] > 0) result += nums[j];
					else result = 0;
					if(result > max) max = result;
				}
				return max;
			}
		}
		
		for(int i = 1; i < nums.length; i++) {
			if(result + nums[i] > 0) result += nums[i];
			else result = nums[i];
			if(result > max) max = result;
		}
		return max;
	}
}
