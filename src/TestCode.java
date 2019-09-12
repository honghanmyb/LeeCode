import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		SkylineProblem test = new SkylineProblem();
		int[][] buildings = new int[][] {
			new int[] {2, 9, 10},
			new int[] {3, 7, 15},
			new int[] {5, 12, 12},
			new int[] {15, 20, 10},
			new int[] {19, 24, 8}
		};
		System.out.println(test.getSkyline(buildings));
		int[][] soloBuilding = new int[][] {
//			new int[] {0,2147483647,2147483647},
//			new int[] {1, 2, 1},
//			new int[] {1, 2, 2},
//			new int[] {1, 2, 3},
//			new int[] {3, 4, 4},
//			new int[] {3, 4, 4},
//			new int[] {3, 4, 4},
			new int[] {3, 10, 20},
			new int[] {3, 9, 19},
			new int[] {3, 8, 18}
		};
		System.out.println(test.getSkyline(soloBuilding));
	}
}
