import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		RotateArray test = new RotateArray();
		int[] nums = new int[] {1,2,3,4,5,6,7};
		test.rotate(nums, 3);
		TestUtils.printArray(nums);
	}
}
