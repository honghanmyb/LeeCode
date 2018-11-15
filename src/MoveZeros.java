
public class MoveZeros {
	public int[] moveZeroes(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				int j = findNearestNonzero(i, nums);
				if(j != -1) swap(i, j, nums);
			}
		}
		return nums;
	}

	/*private int countZeroes(int[] nums) {
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) count++;
		}
		return count;
	}*/
	
	/*private boolean isFinished(int count, int[] nums) {
		int result = 0;
		for(int i = nums.length - 1; i > nums.length - 1 - count; i--) result += nums[i];

		return (result == 0);
	}*/
	
	/*private void zeroMoves(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				int j = findNearestNonzero(i, nums);
				if(j != -1) swap(i, j, nums);
			}
		}
	}*/
	
	private int findNearestNonzero(int i, int[] nums) {
		for(int j = i; j < nums.length; j++) {
			if(nums[j] != 0) return j;
		}
		return -1;
	}
	
	private void swap(int i, int j, int[] nums) {
		
		nums[i] = nums[i] + nums[j];
		nums[j] = nums[i] - nums[j];
		nums[i] = nums[i] - nums[j];
	}
}
