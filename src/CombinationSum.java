import java.util.*;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		for(int i = 0; i < candidates.length; i++) {
			if(candidates[i] > target) continue;
			List<Integer> first = new ArrayList<Integer>();
			first.add(candidates[i]);
			if(candidates[i] == target) {
				result.add(first);
				continue;
			}
			findAll(i,candidates[i], target, candidates, first, result);
		}
		return result;
	}
	private void findAll(int index, int currentSum, int target, int[] candidates, 
			List<Integer> lastList, List<List<Integer>> result) {
		for(int i = index; i < candidates.length; i++) {
			if(candidates[i] + currentSum > target) return;
			List<Integer> currentList = new ArrayList<>();
			currentList.addAll(lastList);
			currentList.add(candidates[i]);
			if(currentSum + candidates[i] == target) {
				result.add(currentList);
				continue;
			}
				findAll(i, currentSum + candidates[i], target, candidates, currentList, result);
			
		}
	}

}
