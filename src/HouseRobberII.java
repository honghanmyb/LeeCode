
public class HouseRobberII {
	/*First reconstruct the array.
	 *There are three situations:
	 *First, the first house is robbed, then the last cannot be robbed.
	 *Second, the last house is robbed, then the first cannot be robbed.
	 *Third, the first and the last both not be robbed.
	 */
	public int rob(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		if(nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
		if(nums.length == 4) return Math.max(nums[0] + nums[2], nums[1] + nums[3]);
		
		int[] newArray1 = reconstruct(nums, 0);
		int[] newArray2 = reconstruct(nums, 1);
		
		
		return Math.max(findMaxRob(newArray1), findMaxRob(newArray2));
	}
	
	private int findMaxRob(int[] newArray) {
		int[] robMoney = new int[newArray.length];
		robMoney[0] = newArray[0]; robMoney[1] = Math.max(newArray[0], newArray[1]);
		for(int i = 2; i < newArray.length; i++) {
			if(robMoney[i - 1] == robMoney[i - 2]) {
				robMoney[i] = newArray[i] + robMoney[i - 1];
				continue;
			}
			robMoney[i] = Math.max(robMoney[i - 2] + newArray[i], robMoney[i - 1]);
			
		}
		
		return robMoney[robMoney.length - 1];
	}
	
	private int[] reconstruct(int[] nums, int flag) {
		int[] newArray = new int[nums.length - 1];
		if(flag == 0) {
			for(int i = 0; i < newArray.length; i++) newArray[i] = nums[i];
			
			return newArray;
		}
		
		for(int i = 0; i < newArray.length; i++) {
			newArray[i] = nums[i + 1];
		}
		
		return newArray;
	}
	
	
}
