import java.util.*;

public class MajorityElement {
	public int majorityElement(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int currentNum = nums[0];
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == currentNum){
                count++;
            }else{
                count--;
            }
            if(count < 0){
                currentNum = nums[i];
                count = 0;
            }
        }
        
        return currentNum;
	} 

}
