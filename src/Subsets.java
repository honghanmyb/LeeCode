import java.util.*;
public class Subsets {
	public List<List<Integer>> subsets(int[] nums){
		for(int i = 0; i < nums.length; i++) {
			findAll(i, nums, null);
		}
		List<Integer> nullset = new ArrayList<>();
		results.add(nullset);
		return results;
	}
	
	private void findAll(int currentNum, int[] nums, List<Integer> last) {
		List<Integer> current = new ArrayList<>();
		if(last != null) {
			for(int i = 0; i < last.size(); i++) current.add(last.get(i));
		}

		current.add(nums[currentNum]);
		results.add(current);
		if(currentNum == nums.length - 1) return;
		for(int i = currentNum + 1; i < nums.length; i++) findAll(i, nums, current);
		
	}
	ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
}
