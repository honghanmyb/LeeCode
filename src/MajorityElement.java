import java.util.*;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length ; i++) {
			if(map.containsKey(nums[i]) == false) {
				map.put(nums[i], 1);
			}else {
				map.put(nums[i], map.get(nums[i]) +1);
			}
			
		}
		int key = nums[0], maxValue = map.get(nums[0]);
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			int temp = (int)keys.next();
			if(map.get(temp) > maxValue) {
				key = temp;
				maxValue = map.get(temp);
			}
		}

		return key;
	} 

}
