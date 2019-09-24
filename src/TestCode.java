import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		KClosest test = new KClosest();
		int[][] points = new int[][] {
			{1, 3}, {2, 2}
		};
		System.out.println(test.kClosest(points, 1));
	}
}
