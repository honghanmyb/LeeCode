import java.util.*;
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndices  = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(valueToIndices.containsKey(target - nums[i])){
                return new int[]{i, valueToIndices.get(target - nums[i])};
            }
            valueToIndices.put(nums[i], i);
        }
        return null;
	}
}
