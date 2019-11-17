import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		StoresAndHousesOA test = new StoresAndHousesOA();
		int[] houses = new int[] {4, 8, 1, 1};
		int[] stores = new int[] {5, 3, 1, 2, 6};
		TestUtils.printArray(test.findStores(houses, stores));
	}
}
