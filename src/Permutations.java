import java.util.*;

public class Permutations {
	public List<List<Integer>> permute(int[] nums){
		for(int i = 0; i < nums.length; i++) {
			addAllPermute(i, 1, nums.length, nums, null);
		}

		
		return resultList;
	}
	
	private void addAllPermute(int numsIndex, int count, int max, int[] nums, List<Integer> lastSequence) {
		List<Integer> sequence = new ArrayList<Integer>();
		if(lastSequence != null) {
			for(int i = 0; i < lastSequence.size(); i++) {
				sequence.add(lastSequence.get(i));
			}
		}
		
		sequence.add(nums[numsIndex]);
		if(count == max) {
			resultList.add(sequence);
			return;
		}
		
		for(int i = 0; i < max; i++) {
			if(!isInSequence(i, sequence, nums)) {
				addAllPermute(i, count + 1, max, nums, sequence);
			}
		}

	}
	
	
	private boolean isInSequence(int index, List<Integer> sequence, int[] nums) {
		for(int i = 0; i < sequence.size(); i++) {
			if(nums[index] == sequence.get(i)) return true;
			
		}
		return false;
	}
	
	private List<List<Integer>> resultList = new ArrayList<List<Integer>>();
	//private List<Integer> sequence1 = new ArrayList<Integer>();
}
