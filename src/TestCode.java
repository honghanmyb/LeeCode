import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		WordSearch test = new WordSearch();
		char[][] borad = new char[][] {
//			new char[] {'A','B','C','E'},
//			new char[] {'S','F','C','S'},
//			new char[] {'A','D','E','E'}
			new char[] {'a'}
		};
		String word = "a";
		System.out.println(test.exist(borad, word));
	}
}
