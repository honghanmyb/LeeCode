
public class JumpGame {
	public boolean canJump(int[] nums) {
		int longestLength = 0;
		for(int i = 0; i < nums.length; i++) {
			if(longestLength >= i) {
				longestLength = Math.max(longestLength, nums[i] + i);
			}
		}
		if(longestLength >= nums.length - 1) {
			return true;
		}
		return false;
	}
}
