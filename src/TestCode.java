import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		MaximalRectangle test = new MaximalRectangle();
		char[][] matrix = new char[][] {
			new char[] {'1','0','1','1','1'},
			new char[] {'0','1','0','1','0'},
			new char[] {'1','1','0','1','1'},
			new char[] {'1','1','0','1','1'},
			new char[] {'0','1','1','1','1'}
		};
		System.out.println(test.maximalRectangle(matrix));
	}
}
