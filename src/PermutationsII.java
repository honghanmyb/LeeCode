import java.util.*;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums){
		Arrays.sort(nums);
		List<Integer> record = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		
		if(nums.length == 0) return result;
		for(int i = 0; i < nums.length; i++) {
			addAllPermutes(i, i == 0 ? nums[0] - 1 : nums[i - 1], record, result, nums);
		}
		return result;
	}
	
	private void addAllPermutes(int index, int cannotRepeat, List<Integer> record, 
			List<List<Integer>> result, int[] nums) {
		
		if(cannotRepeat == nums[index]) return;
		
		
		
		if(record.size() == nums.length) {
			List<Integer> sequence = new ArrayList<>();
			sequence.addAll(record);
			result.add(sequence);
			
		}
		
		
	}
}
