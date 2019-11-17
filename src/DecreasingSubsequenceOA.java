
public class DecreasingSubsequenceOA {
	public int minNumSplit(int[] nums) {
		boolean[] taken = new boolean[nums.length];
		int count = 0;
		int currentNum;
		for(int i = 0; i < nums.length; i++) {
			if(taken[i]) {
				continue;
			}
			currentNum = nums[i];
			taken[i] = true;
			for(int j = i + 1; j < nums.length; j++) {
				if(!taken[j] && nums[j] < currentNum) {
					taken[j] = true;
					currentNum = nums[j];
				}
			}
			count++;
		}
		return count;
	}
}
