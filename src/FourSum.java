import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target){
		Arrays.sort(nums);
		List<List<Integer>> fourSumList = new ArrayList<>();
		Set<List<Integer>> fourSumSet = new HashSet<>();
		if(nums.length < 4) {
			return fourSumList;
		}
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				int currentSum = nums[i] + nums[j];
				int currentTarget = target - currentSum;
				Set<Integer> set = new HashSet<>();
				for(int k = j + 1; k < nums.length; k++) {
					if(set.contains(currentTarget - nums[k])) {
						List<Integer> currentList = Arrays.asList(nums[i], nums[j], nums[k], currentTarget - nums[k]);
						if(!fourSumSet.contains(currentList)) {
							fourSumSet.add(currentList);
						}
					}
					set.add(nums[k]);
				}
			}
		}
		fourSumList.addAll(fourSumSet);
		return fourSumList;
	}
}
