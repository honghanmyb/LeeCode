
public class LongestIncreaseSequence {
	public int lengthOfLIS(int[] nums) {
		if(nums.length == 0) return 0;
		int maxLength = 1;
		int currentLength = 1;
		int[] marks = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			if(marks[i] == 0) {
				int current = i;
				for(int j = i + 1; j < nums.length - 1; j++) {
					if(nums[j] > nums[current]) {
						if(nums[j] < nums[j + 1] || nums[current] >= nums[j + 1]) {
							current = j;
							currentLength++;
							marks[j] = 1;
						}
					}
					if(nums[j] == nums[current]) marks[j] = 1;
				}
				if(nums[nums.length - 1] > nums[current]) {
					currentLength++;
					marks[nums.length - 1] = 1;
				}
				if(currentLength > maxLength) maxLength = currentLength;
				currentLength = 1;
			}
		}
		return maxLength;
	}
}
