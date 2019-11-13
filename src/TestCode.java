import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		LargestSubarrayLengthKOA test = new LargestSubarrayLengthKOA();
		int[] A = new int[] {
				1,4,3,2,5
		};
		int[] subarray = test.largestSubarray(A, 3);
		for(int i : subarray) {
			System.out.print(i + ", ");
		}
	}
}
