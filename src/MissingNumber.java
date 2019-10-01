
public class MissingNumber {
	public int missingNumber(int[] nums) {
        int missingNum = 0;
        for(int i = 0; i < nums.length; i++){
            missingNum += i + 1;
            missingNum -= nums[i];
        }
        return missingNum;
	}
}
