import java.util.Arrays;

public class JumpGameII {
	public int jump(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        int[] jumpTimes = new int[nums.length];
        boolean[] canJump = new boolean[nums.length];
        jumpTimes[0] = 0;
        canJump[0] = true;
        int currentFarest = 0;
        int lastFarest = 0;
        for(int i = 0; i < nums.length; i++){
            currentFarest = i + nums[i];
            for(int j = lastFarest + 1; j <= Integer.min(currentFarest, nums.length - 1); j++){
                if(canJump[j] == false){
                    jumpTimes[j] = jumpTimes[i] + 1;
                    canJump[j] = true;
                }
                lastFarest = currentFarest;
            }
        }
        return jumpTimes[nums.length - 1];
	}
}
