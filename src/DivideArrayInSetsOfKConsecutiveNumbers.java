import java.util.Arrays;

public class DivideArrayInSetsOfKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0){
            return false;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                continue;
            }
            int curNum = nums[i];
            int curCount = 1;
            nums[i] = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] == curNum + 1){
                    curNum = nums[j];
                    curCount++;
                    nums[j] = 0;
                    if(curCount == k){
                        curCount = 0;
                        break;
                    }
                }
            }
            if(curCount != 0){
                return false;
            }
        }
        return true;
    }
}
