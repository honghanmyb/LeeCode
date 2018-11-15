import java.util.*;
public class Combinations {
	public List<List<Integer>> combine(int n, int k){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i = 1; i < n + 2 - k; i++) {
			List<Integer> firstStep = new ArrayList<>();
			firstStep.add(i);
			if(k == 1) {
				result.add(firstStep);
				continue;
			}
			findAll(i, n, k - 1, firstStep, result);
		}
		return result;
	}
	
	private void findAll(int currentNum, int n, int count, List<Integer>last, List<List<Integer>> result) {
		for(int i = currentNum + 1; i < n + 2 - count; i++) {
			List<Integer> current = new ArrayList<>();
			current.addAll(last);
			current.add(i);
			if(count == 1) {
				result.add(current);
				continue;
			}else {
				findAll(i, n, count - 1, current, result);
			}
		}
		
	}
}
