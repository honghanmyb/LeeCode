
public class SplitArrayMinimumSum {
	/**
	 * given array nums and int m, split the array into m continuous sub arrays
	 * try to maximize the minimum sum of the sub array
	 */
	public int splitArray(int[] nums, int m) {
		int minVal = nums[0];
		int maxVal = 0;
		for(int num: nums) {
			minVal = Integer.min(minVal, num);
			maxVal += num;
		}
		if(maxVal <= 0) {
			maxVal = Integer.MAX_VALUE;
		}
		if(m == 1) {
			return maxVal;
		}
		while(minVal <= maxVal) {
			int middle = minVal + (maxVal - minVal) / 2;
			if(canSplit(middle, nums, m)) {
				minVal = middle + 1;
			}else {
				maxVal = middle - 1;
			}
		}
		return maxVal;
	}
	
	private boolean canSplit(int target, int[] nums, int m) {
		int currentSum = 0;
		for(int num: nums) {
			currentSum += num;
			if(currentSum >= target) {
				currentSum = 0;
				m -= 1;
				if(m <= 0) {
					return true;
				}
			}
		}
		return false;
	}
}
