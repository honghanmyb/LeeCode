import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		MergeIntervals test = new MergeIntervals();
		int[][] intervals = new int[4][];
		int[] int0 = {2, 3};
		int[] int1 = {4, 6};
		int[] int2 = {5, 7};
		int[] int3 = {3, 4};
		intervals[0] = int0;
		intervals[1] = int1;
		intervals[2] = int2;
		intervals[3] = int3;
		int[][] result = test.merge(intervals);
		for(int i = 0; i < result.length; i++) {
			int[] interval = result[i];
			for(int j = 0; j < interval.length; j++) {
				System.out.print(interval[j] + " ");
			}
			System.out.println("\n");
		}
	}
}
