import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		RemoveDuplicateII test = new RemoveDuplicateII();
		
		int[] nums = {0,0,1,1,1,1,2,2,2,4};
		
		int length = test.removeDuplicates(nums);
		System.out.println(length);
		for(int i = 0; i < length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
