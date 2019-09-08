
public class MaximumGap {
	public int maximumGap(int[] nums) {
		if(nums.length <= 1) {
			return 0;
		}
		if(nums.length == 2) {
			return Math.abs(nums[0] - nums[1]);
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int num: nums) {
			if(num > max) {
				max = num;
			}
			if(num < min) {
				min = num;
			}
		}
		if(max == min) {
			return 0;
		}
		int buckets[] = new int[max - min + 1];
		for(int num: nums) {
			buckets[num - min] = 1;
		}
		
		int maxGap = 0;
		int currentGap = 0;
		for(int bucket: buckets) {
			if(bucket == 1) {
				maxGap = Integer.max(maxGap, currentGap);
				currentGap = 0;
				continue;
			}
			currentGap++;
		}
		
		return maxGap + 1;
	}
}
