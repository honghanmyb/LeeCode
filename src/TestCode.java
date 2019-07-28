import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		MinSizeSubarraySum test = new MinSizeSubarraySum();
		int[] nums = new int[] {2,3,1,2,4,3};
		int s = 4;
		System.out.println(test.minSubArrayLen(s, nums));
	}
}
