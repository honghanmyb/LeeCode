import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if(nums.length == 3) {
			return nums[0] + nums[1] + nums[2];
		}
		
		Arrays.sort(nums);
		int closestSum = nums[0] + nums[1] + nums[nums.length - 1];
		for(int i = 0; i < nums.length - 2; i++) {
			int temp = getClosestSumWithIndex(i, nums, target);
			if(Math.abs(temp - target) < Math.abs(closestSum - target)) {
				closestSum = temp;
			}
		}
		return closestSum;
	}
	
	private int getClosestSumWithIndex(int index, int[] nums, int target) {
		int startFlag = index + 1;
		int endFlag = nums.length - 1;
		int threeSumTemp = nums[index] + nums[startFlag] + nums[endFlag];
		while(startFlag < endFlag) {
			int sum = nums[index] + nums[startFlag] + nums[endFlag];
			if(Math.abs(sum - target) < Math.abs(threeSumTemp - target)) {
				threeSumTemp = sum;
			}
			if(sum > target) endFlag--;
			if(sum < target) startFlag++;
			if(sum == target) return sum;
			
		}
		
		return threeSumTemp;
	}
}
