import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		MergeSortedArray test = new MergeSortedArray();
		int[] nums1 = {0};
		int[] nums2 = {};
		test.merge(nums1, 0, nums2, 0);
		
		for(int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i] + ", ");
		}
	}
}
