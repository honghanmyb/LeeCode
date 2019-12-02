import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		OptimalAccountBalancing test = new OptimalAccountBalancing();
		int[][] transactions = new int[][]{
				{1,8,1}, {1,13,21},{2,8,10},{3,9,20},{4,10,61},{5,11,61},{6,12,59},{7,13,60}
		};
		System.out.println(test.minTransfers(transactions));
	}
}
