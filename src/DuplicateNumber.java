import java.util.*;
public class DuplicateNumber {
	public int findDuplicate(int[] nums) {
   		HashSet<Integer> set = new HashSet<>();

	for(int i = 0; i < nums.length; i++) {
		if(!set.add(nums[i])) {
			return nums[i];
		}
	}
	return 0;
	}
}
