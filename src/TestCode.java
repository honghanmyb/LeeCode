import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		EvaluateRPN test = new EvaluateRPN();
		String[] tokens = new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(test.evalRPN(tokens));
	}
}
