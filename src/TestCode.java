import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		String[] words = new String[] {"i love you","island","iroman","i love leetcode"};
		int[] times = new int[] {5,3,2,2};
		AutocompleteSystem test = new AutocompleteSystem(words, times);
		System.out.println(test.input('i'));
		System.out.println(test.input(' '));
		System.out.println(test.input('a'));
		System.out.println(test.input('#'));
		System.out.println(test.input('i'));
		System.out.println(test.input(' '));
		System.out.println(test.input('a'));
	}
}
