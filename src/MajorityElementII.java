import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums){
		List<Integer> majorityElements = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return majorityElements;
		}
		int treshHold = nums.length / 3;
		int firstCandidate = nums[0], value = 0;
		for(int num: nums) {
			if(value == 0) {
				firstCandidate = num;
			}
			if(num == firstCandidate) {
				value += 2;
			}else {
				value -= 1;
			}
		}
		for(int num: nums) {
			if(num == firstCandidate) {
				treshHold--;
			}
		}
		if(treshHold < 0) {
			majorityElements.add(firstCandidate);
		}
		treshHold = nums.length / 3;
		value = 0;
		int secondCandidate = nums[0];
		for(int num: nums) {
			if(value == 0) {
				secondCandidate = num;
			}
			if(num == firstCandidate) {
				continue;
			}else if(num == secondCandidate) {
				value++;
			}else {
				value--;
			}
		}
		for(int num: nums) {
			if(num == secondCandidate) {
				treshHold--;
			}
		}
		if(treshHold < 0 && secondCandidate != firstCandidate) {
			majorityElements.add(secondCandidate);
		}
		return majorityElements;
	}
}
