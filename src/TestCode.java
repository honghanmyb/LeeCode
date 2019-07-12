import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		ValidParentheses test = new ValidParentheses();
		System.out.println(test.isValid("()()[]{[]}"));
		System.out.println(test.isValid("((({{]}})))"));
		System.out.println(test.isValid("((({{"));
	}

}
