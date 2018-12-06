import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		RemoveDuplicateInPlace test = new RemoveDuplicateInPlace();
		
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		
		int length = test.removeDuplicates(nums);
		System.out.println(length);
		for(int i = 0; i < length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
