import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		CourseScheduleII test = new CourseScheduleII();
		int[][] prerequisites = new int[4][];
		prerequisites[0] = new int[] {1, 0};
		prerequisites[1] = new int[] {2, 0};
		prerequisites[2] = new int[] {3, 1};
		prerequisites[3] = new int[] {3, 2};
		int[] result = test.findOrder(4, prerequisites);
		for(int i = 0; i < result.length; i++) {
			System.out.print(i + " ");
		}
	}
}
