
public class FindFirstAndLastPositionOfElementInSortedArray {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] {-1, -1};
		if(nums == null || nums.length == 0) {
			return result;
		}
		int posHead = Integer.MAX_VALUE, posEnd = Integer.MIN_VALUE;
		int head = 0, end = nums.length - 1;
		int lastMiddle = -1;
		if(nums[end] == target) {
			posHead = end;
			posEnd = end;
		}
		while(true) {
			int middle = (head + end) / 2;
			if(middle == lastMiddle) {
				break;
			}
			if(nums[middle] == target) {
				posHead = Math.min(middle, posHead);
				end = middle;
			}
			if(nums[middle] > target) {
				end = middle;
			}
			if(nums[middle] < target) {
				head = middle;
			}
			lastMiddle = middle;
		}
		if(posHead == Integer.MAX_VALUE) {
			return result;
		}
		head = 0;
		end = nums.length - 1;
		lastMiddle = -1;
		while(true) {
			int middle = (head + end) / 2;
			if(middle == lastMiddle) {
				break;
			}
			if(nums[middle] == target) {
				posEnd = Math.max(middle, posEnd);
				head = middle;
			}
			if(nums[middle] > target) {
				end = middle;
			}
			if(nums[middle] < target) {
				head = middle;
			}
			lastMiddle = middle;
		}
		result[0] = posHead;
		result[1] = posEnd;
		return result;
	}
}
