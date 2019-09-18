import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		WordDictionary test = new WordDictionary();
		test.addWord("bad");
		test.addWord("dad");
		test.addWord("mad");
		
		System.out.println(test.search("pad"));
		System.out.println(test.search("bad"));
		System.out.println(test.search(".ad"));
		System.out.println(test.search("b.."));
	}
}
