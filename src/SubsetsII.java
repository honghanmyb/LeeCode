import java.util.*;
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		subsets.add(new ArrayList<>());
		if(nums.length == 0) return subsets;
		List<Integer> newSubset = new ArrayList<>();
		newSubset.add(nums[0]);
		subsets.add(newSubset);
		for(int i = 1; i < nums.length; i++) {
			addSubsetsWithI(nums[i], subsets, nums[i] == nums[i - 1]);
		}
		
		return subsets;
	}
	
	private void addSubsetsWithI(int newNumber, List<List<Integer>> subsets, boolean equalToPrevious) {
		int currentSubsetSize = subsets.size();
		int i = 0;
		if(equalToPrevious) {
			i = (currentSubsetSize + 1) / 2;
		}
		for(; i < currentSubsetSize; i++) {
			List<Integer> newSubset = new ArrayList<>();
			newSubset.addAll(subsets.get(i));
			newSubset.add(newNumber);
			if(!subsets.contains(newSubset)) {
				subsets.add(newSubset);
			}

		}
	}
}
