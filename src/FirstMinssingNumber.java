import java.util.*;
public class FirstMinssingNumber {
	public int firstMissingPositive(int[] nums) {
		/**********HashSet solution************/
		/*HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int missingPositive = 1;
		while(set.contains(missingPositive++)) {
			
		}
		
		return --missingPositive;*/
		
		/*****Building a hash set manually**********/
		int[] records = new int[nums.length];
		int missingPositive = 0;
		for(int i = 0; i < records.length; i++) {
			if(nums[i] > 0 && nums[i] < nums.length + 1) {
				records[nums[i] - 1] = nums[i];
			}
		}
		for(int i = 0; i < records.length; i++) {
			if(records[i] == 0) {
				missingPositive = i + 1;
				break;
			}
		}
		if(missingPositive == 0) {
			missingPositive = records.length + 1;
		}
		
		return missingPositive;
		
	}
}
