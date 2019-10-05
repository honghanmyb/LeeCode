import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		String test = "{a,b}c{d,e}f";
		String[] split = test.split("\\{|}");
		for(String testSplit: split) {
			System.out.println(testSplit);
		}
	}
}
