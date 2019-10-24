
public class CheckIfElementEqualToIndex {
	/**
	 * This method takes a sorted array, and checks if there exists certain element 
	 * such that nums[i] == i
	 * return true if there is, false if there isn't
	 */
	public boolean check(int[] nums) {
		if(nums.length == 0) {
			return false;
		}
		if(nums[0] >= nums.length) {
			return false;
		}
		if(nums[nums.length - 1] < 0) {
			return false;
		}
		
		return false;
	}
}
