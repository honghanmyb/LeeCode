import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		PalindromePartitioning test = new PalindromePartitioning();
		List<List<String>> result = test.partition("aab");
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}
}
