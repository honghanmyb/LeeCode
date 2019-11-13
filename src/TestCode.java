import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		MaximumTime test = new MaximumTime();
		System.out.println(test.maxTime("?4:5?"));
		System.out.println(test.maxTime("23:5?"));
		System.out.println(test.maxTime("2?:22"));
		System.out.println(test.maxTime("0?:??"));
		System.out.println(test.maxTime("??:??"));
	}
}
