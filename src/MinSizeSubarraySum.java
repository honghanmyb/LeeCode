
public class MinSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int minLen = Integer.MAX_VALUE;
		int headIndex = 0, tailIndex = 0;
		while(tailIndex < nums.length) {
			if(s <= 0) {
				minLen = Math.min(minLen, headIndex - tailIndex); 
				s += nums[tailIndex++];
				continue;
			}
			
			if(s > 0) {
				if(headIndex >= nums.length) {
					break;
				}
				s -= nums[headIndex++];
				continue;
			}
		}
		if(minLen == Integer.MAX_VALUE) {
			return 0;
		}
		return minLen;
	}
}
