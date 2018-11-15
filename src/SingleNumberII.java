import java.util.*;
public class SingleNumberII {
	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length ; i++) {
			if(map.containsKey(nums[i]) == false) map.put(nums[i], 1);
			else {
				if(map.get(nums[i]) == 2) map.remove(nums[i]);
				else map.put(nums[i], 2);
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) return nums[i];
		}
		return 0;
	}
}
