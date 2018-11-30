import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		LongestConsecutiveSequence test = new LongestConsecutiveSequence();
		
		int[] nums = {100, 4, 200, 1, 3, 2,5,8,9,6,7,50,49,48,47};
		System.out.println(test.longestConsecutive(nums));
	}
}
