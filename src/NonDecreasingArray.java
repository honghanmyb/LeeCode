import java.util.*;

public class NonDecreasingArray {
	public boolean checkPossiblity(int[] nums){
		if(nums.length < 3) return true;
		int count = 0;
		if(nums[1] < nums[0]) {
			nums[0] = nums[1];
			count++;
		}
		int i = 1;
		while(true) {
			if(nums[i] > nums[i + 1] && nums[i + 1] >= nums[i - 1]) {
				nums[i] = nums[i + 1];
				//i++;
				count++;
				
			}else if(nums[i] >= nums[i - 1] && nums[i - 1] > nums[i + 1]) {
				nums[i + 1] = nums[i];
				count ++;
				//i++;
			}
			i++;
			if(count > 1) return false;
			if(i == nums.length - 1) break;
			
		}
		return true;
	}
}
