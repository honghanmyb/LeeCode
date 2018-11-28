import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		TrapRainWater test = new TrapRainWater();
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println(test.trap(height));
	}
}
