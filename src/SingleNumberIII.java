import java.util.*;
/*
 * Next time think of using XOR operation.
 */
public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		HashSet record = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(!record.add(nums[i])) {
				record.remove(nums[i]);
			}
		}
		Iterator iterOfInt = record.iterator();
		int[] num = new int[2];
		int i = 0;
		while(iterOfInt.hasNext()) {
			num[i++] = (int) iterOfInt.next();
			
		}
		return num;
	}
}
