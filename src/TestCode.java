import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		WaterFlowerOA test = new WaterFlowerOA();
		int[] plants = new int[] {4};
		int capacity1 = 5, capacity2 = 5;
		System.out.println(test.numOfRefill(plants, capacity1, capacity2));
	}
}
