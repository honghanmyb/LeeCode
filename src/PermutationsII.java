import java.util.*;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums){
//		Arrays.sort(nums);
//		List<Integer> record = new ArrayList<>();
//		List<List<Integer>> result = new ArrayList<>();
//		
//		if(nums.length == 0) return result;
//		for(int i = 0; i < nums.length; i++) {
//			addAllPermutes(i, i == 0 ? nums[0] - 1 : nums[i - 1], record, result, nums);
//		}
//		return result;
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		if(nums == null) return result;
		for(int i = 0; i < nums.length; i++) {
			boolean[] numInList = new boolean[nums.length];
			addNumToTemp(i, nums, numInList, temp, result);
		}
		
		return result;
	}
	
	private void addNumToTemp(int index, int[] nums, boolean[] numInList,
			List<Integer> temp, List<List<Integer>> result) {
		temp.add(nums[index]);
		numInList[index] = true;
		if(temp.size() == nums.length) {
			if(isUnique(temp, result)) {
				List<Integer> newList = new ArrayList<>();
				newList.addAll(temp);
				result.add(newList);
			}
			temp.remove(temp.size() - 1);
			numInList[index] = false;
			return;
		for(int i = 0; i < nums.length; i++) {
			if(!numInList[i]) {
				addNumToTemp(i, nums, numInList, temp, result);
			}
		}
		
		temp.remove(temp.size() - 1);
		numInList[index] = false;
	}
	
	private boolean isUnique(List<Integer> temp, List<List<Integer>> result) {
		Iterator<List<Integer>> resultIterator = result.iterator();
		while(resultIterator.hasNext()) {
			if(temp.equals(resultIterator.next())) return false;
		}
		
		return true;
	}
	
//	private void addAllPermutes(int index, int cannotRepeat, List<Integer> record, 
//			List<List<Integer>> result, int[] nums) {
//		if(cannotRepeat == nums[index]) return;
//		if(record.size() == nums.length) {
//			List<Integer> sequence = new ArrayList<>();
//			sequence.addAll(record);
//			result.add(sequence);	
//		}
//	}
}
