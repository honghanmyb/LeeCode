import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		GasStation test = new GasStation();
		int[] gas = new int[] {5, 1, 2, 3, 4};
		int[] cost = new int[] {4, 4, 1, 5, 1};
		
		System.out.println(test.canCompleteCircuit(gas, cost));
	}
}
