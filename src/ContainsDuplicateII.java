import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> firstSet = new HashSet<>();
		HashSet<Integer> secondSet = new HashSet<>();
		for(int num: nums) {
			if(!firstSet.add(num)) {
				secondSet.add(num);
			}
		}
		
		Iterator<Integer> setIterator = secondSet.iterator();
		while(setIterator.hasNext()) {
			int duplicateElement = setIterator.next();
			Stack<Integer> elementStack = new Stack<>();
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] == duplicateElement) {
					elementStack.add(i);
				}
			}
			int lastIndex = elementStack.pop();
			while(!elementStack.isEmpty()) {
				int nextIndex = elementStack.pop();
				if(lastIndex - nextIndex <= k) {
					return true;
				}
				lastIndex = nextIndex;
			}
		}
		return false;
	}
}
