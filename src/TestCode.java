import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		int[] nums = {1, 1, -1, -1, 3};
		int target = -1;
		ThreeSumClosest test = new ThreeSumClosest();
		System.out.println(test.threeSumClosest(nums, target));
	}
}
