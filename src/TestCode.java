import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		Trie test = new Trie();
		test.insert("apple");
		System.out.println(test.search("apple"));
		System.out.println(test.search("appl"));
		System.out.println(test.startsWith("app"));
		test.insert("app");
		System.out.println(test.search("app"));
	}
}
