
public class Rob {
	public int rob(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		
		int[] s = new int[nums.length];
		s[0] = nums[0];
		s[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i < nums.length; i++) {
			if(s[i - 1] == s[i - 2]) {
				s[i] = s[i - 2] + nums[i];
				continue;
			}
			if(nums[i] + s[i - 2] >= s[i - 1]) {
				s[i] = s[i - 2] + nums[i];
				continue;
			}else {
				s[i] = s[i - 1];
			}
			
		}
		
		return s[nums.length - 1];
	}
}
