
public class SearchRotatedSortedArray {
	public int search(int[] nums, int target) {
		return searchInArray(nums, target, 0, nums.length - 1);
	}
	
	private int searchInArray(int[] nums, int target, int start, int end) {
		if(start == end) {
			if(nums[start] == target) {
				return start;
			}
			return -1;
		}
		if(nums[start] < nums[end]) {
			while(start < end) {
				int middle = (start + end) / 2;
				if(nums[middle] == target) {
					return middle;
				}
				if(middle == start) {
					if(nums[end] == target) {
						return end;
					}
					break;
				}
				if(nums[middle] > target) {
					end = middle;
				}
				if(nums[middle] < target) {
					start = middle;
				}
			}
			return -1;
		}
		if(start == end - 1) {
			if(nums[start] == target) {
				return start;
			}
			if(nums[end] == target) {
				return end;
			}
			return -1;
		}
		int middle = (start + end) / 2;
		return Math.max(searchInArray(nums, target, start, middle), searchInArray(nums, target, middle, end));
	}
}
