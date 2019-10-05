import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		CampusBikes test = new CampusBikes();
		int[][] workers = new int[][] {
				{0, 0},
				{1, 1},
				{2, 0}
		};
		int[][] bikes = new int[][] {
			{1, 0},
			{2, 2},
			{2, 1}
		};
		test.assignBikes(workers, bikes);
	}
}
