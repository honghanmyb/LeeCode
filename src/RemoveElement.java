
public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int count = nums.length;
		for(int k = nums.length - 1; k >= 0; k--) {
			if(nums[k] == val) count--;
		}
		if(count == 0) return count;
		int i = 0; int j = nums.length - 1;
		while(i < j) {
			while(nums[i] != val && i < j) {
				i++;
			}
			while(nums[j] == val) {

				j--;
			}
			if(i < j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;

			}

		}
		return count;
	}
}
