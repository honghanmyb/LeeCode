
public class RotateArray {
	public void rotate(int[] nums, int k) {
		int[] rotatedNums = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			rotatedNums[(i + k) % nums.length] = nums[i];
		}
		nums = rotatedNums;
	}
}
