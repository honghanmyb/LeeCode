import java.util.*;

public class SingleNumberI {
	public int singleNumber(int[] nums) {
		
		HashSet<Integer> test = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(!test.add(nums[i])) test.remove(nums[i]);
		}

		return test.iterator().next();
	}
}
