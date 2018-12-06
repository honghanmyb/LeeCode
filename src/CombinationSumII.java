import java.util.*;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<>();
		if(candidates.length == 0) return result;
		Arrays.sort(candidates);
		HashSet<List<Integer>> set = new HashSet<>();
		for(int i = 0; i < candidates.length; i++) {
			List<Integer> firstList = new ArrayList<>();
//			firstList.add(candidates[i]);
			if(i > 0 && candidates[i] == candidates[i - 1]) continue;
			findList(firstList, i, candidates, target, result, set);
		}
		return result;
	}
	
	
	private void findList(List<Integer> lastList, int index, int[] candidates, 
		int target, List<List<Integer>>result, HashSet<List<Integer>> set) {
		
		if(index == candidates.length) return;
		if(candidates[index] > target) return;
		List<Integer> current = new ArrayList<>();
		current.addAll(lastList);//save status.
		current.add(candidates[index]);
		if(candidates[index] == target) {
			if(!set.contains(current)) {
				result.add(current);
				set.add(current);
			}
//			result.add(current);
			return;
		}
		for(int i = index + 1; i < candidates.length; i++) {
//			if(candidates[i] == candidates[index]) continue; 
			findList(current, i, candidates, target - candidates[index], result, set);
		}
	}
}
