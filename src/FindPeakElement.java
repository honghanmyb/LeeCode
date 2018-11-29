
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		if(nums.length == 1) return 0;
		if(nums[0] > nums[1]) return 0;
		if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
		
		
		return findPeakIndex(nums, 0, nums.length - 1);
	}
	
	
	private int findPeakIndex(int[] nums, int head, int tail) {
			
		if(tail == head) return head;
		int middleIndex = (head + tail) / 2;
		if(nums[middleIndex] > nums[middleIndex + 1]) {
			return findPeakIndex(nums, head, middleIndex);
		}
		return findPeakIndex(nums, middleIndex + 1, tail);
		

	}
	

}
