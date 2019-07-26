import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		WordPattern test = new WordPattern();
		String pattern = "abba";
		String str = "dog dog dog dog";
		System.out.println(test.wordPattern(pattern, str));
	}
}
