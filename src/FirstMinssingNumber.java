import java.util.*;
public class FirstMinssingNumber {
	public int firstMissingPositive(int[] nums) {
        boolean containsOne = false;
        for(int num: nums){
            if(num == 1){
                containsOne = true;
                break;
            }
        }
        if(!containsOne){
            return 1;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            int numFlag = nums[i];
            numFlag = numFlag > 0? numFlag: -numFlag;
            nums[numFlag - 1] = nums[numFlag - 1] > 0? -nums[numFlag - 1]: nums[numFlag - 1];
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return nums.length + 1;
	}
}
