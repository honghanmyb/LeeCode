
public class ProductExceptItself {
	public int[] productExceptItself(int[] nums) {
		int[] result = new int[nums.length];
		int[] temp = new int[nums.length];
		int s = result[0] = 1;
		for(int i = 1; i < nums.length; i++) {
			result[i] = nums[i-1] * s;
			s = result[i];
			
		}
		s = temp[nums.length-1] = 1;
		for(int i = nums.length - 2; i > -1; i--) {
			temp[i] = nums[i+1] * s;
			s = temp[i];
		}
		for(int i = 0; i < nums.length; i++) {
			result[i] *= temp[i];
		}
		return result;
	}
}
