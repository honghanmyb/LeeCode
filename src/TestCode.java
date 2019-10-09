import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		String[] words = new String[] {"cd", "f", "kl"};
		StreamChecker test = new StreamChecker(words);
		System.out.println(test.query('a'));
	}
}
