import java.util.*;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if(nums.length == 0) return 0;
		int max = 1;
		HashSet<Integer> numSet = new HashSet<>();
		for(int i = 0; i < nums.length; i++) {
			numSet.add(nums[i]);
		}
		for(int i = 0; i < nums.length; i++) {
			if(numSet.contains(nums[i])) {
				currentLongest = 0;
				findConsecutive(nums[i], numSet);
				if(max < currentLongest) max = currentLongest;
			}
		}
		
		return max;
	}
	
	private void findConsecutive(int number, HashSet<Integer> numSet) {
		if(!numSet.contains(number)) return;
		numSet.remove(number);
		currentLongest++;
		findConsecutive(number - 1, numSet);
		findConsecutive(number + 1, numSet);
	}

	private int currentLongest = 1;
}
