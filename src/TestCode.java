import java.util.*;
public class TestCode {
	public static void main(String[] args) {
//		PalindromePartitioning test = new PalindromePartitioning();
//		List<List<String>> result = test.partition("aab");
//		for(int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i));
//		}
		MyStack test = new MyStack();
		test.push(1);
		test.push(2);;
		test.push(3);
		
		System.out.println(test.top());
		System.out.println(test.pop());
		System.out.println(test.pop());
		System.out.println(test.empty());
		System.out.println(test.pop());
		System.out.println(test.empty());
	}
}
