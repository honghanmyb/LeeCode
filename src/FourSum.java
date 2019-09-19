import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target){
		Arrays.sort(nums);
		List<List<Integer>> fourSumList = new ArrayList<>();
		if(nums.length < 4) {
			return fourSumList;
		}
		boolean lastRoundFindMatchI = false;
		for(int i = 0; i < nums.length; i++) {
			if(i > 0 && nums[i] == nums[i - 1] && lastRoundFindMatchI) {
				continue;
			}
			lastRoundFindMatchI = false;
			boolean lastRoundFindMatchJ = false;
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] == nums[j - 1] && lastRoundFindMatchJ) {
					continue;
				}
				lastRoundFindMatchJ = false;
				int currentTarget = target - nums[i] - nums[j];
				int head = j + 1, tail = nums.length - 1;
				boolean previousFindMatch = false;
				while(head < tail) {
					if(previousFindMatch) {
						if(nums[head] != nums[head - 1] && nums[tail] != nums[tail + 1]) {
							previousFindMatch = false;
						}
						if(nums[head] == nums[head - 1]) {
							head++;
						}
						if(nums[tail] == nums[tail + 1]) {
							tail--;
						}
					}else {
						int currentSum = nums[head] + nums[tail];
						if(currentSum < currentTarget) {
							head++;
							continue;
						}
						if(currentSum > currentTarget) {
							tail--;
							continue;
						}
						lastRoundFindMatchJ = true;
						lastRoundFindMatchI = true;
						fourSumList.add(Arrays.asList(nums[i], nums[j], nums[head], nums[tail]));
						head++;
						tail--;
						previousFindMatch = true;
					}
				}
			}
		}
		return fourSumList;
	}
}
