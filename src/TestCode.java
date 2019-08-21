import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		FindFirstAndLastPositionOfElementInSortedArray test = new FindFirstAndLastPositionOfElementInSortedArray();
		int[] nums = new int[] {10};
		int[] result = test.searchRange(nums, 10);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
