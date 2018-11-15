import java.util.*;
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(record.containsKey(nums[i])) {
				if(nums[record.get(nums[i])] + nums[i] == target) {
					result[0] = record.get(nums[i]);
					result[1] = i;
					return result;
				}

			}
			record.put(nums[i], i);
			record.put(target - nums[i], i);
		}
		
		return result;
	}
}
