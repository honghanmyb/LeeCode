
public class SlideWindowMax {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length == 0) return new int[]{};
		int head = 0;
		int tail = k - 1;
		int maxPos = 0;
		int[] result = new int[nums.length - k + 1];
		maxPos = getMaxPos(head, tail, nums);
		result[0] = nums[maxPos];
		for(int i = k; i < nums.length; i++) {
			head++;
			tail++;
			if(head <= maxPos) {
				if(nums[tail] < nums[maxPos]) {
					result[i - k + 1] = nums[maxPos];
				}else {
					result[i - k + 1] = nums[tail];
					maxPos = tail;
				}
			}else {
				maxPos = getMaxPos(head, tail, nums);
				result[i - k + 1] = nums[maxPos];
			}
		}
		return result;
	}
	
	private int getMaxPos(int head, int tail, int[] nums) {
		int max = head;
		for(int i = head; i <= tail; i++) {
			if(nums[i] > nums[max]) max = i;
		}
		
		return max;
	}
}
