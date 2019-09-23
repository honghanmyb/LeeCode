import java.util.Arrays;

public class JumpGameII {
	public int jump(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        int[] jumpTimes = new int[nums.length];
        Arrays.fill(jumpTimes, Integer.MAX_VALUE);
        jumpTimes[0] = 0;
        int currentFarest = 0;
        for(int i = 0; i < nums.length; i++){
            currentFarest = i + nums[i];
            for(int j = i; j <= Integer.min(currentFarest, nums.length - 1); j++){
                jumpTimes[j] = Integer.min(jumpTimes[j], jumpTimes[i] + 1);
            }
        }
        return jumpTimes[nums.length - 1];
	}
}
