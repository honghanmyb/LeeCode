import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		PlusOne test = new PlusOne();
		int[] digits = {9,9,9,9};
		digits = test.plusOne(digits);
		for(int i = 0; i < digits.length; i++) {
			System.out.print(digits[i]);
		}
	}
}
