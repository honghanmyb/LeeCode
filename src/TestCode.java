import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		MyQueue test = new MyQueue();
		test.push(1);
		test.push(2);
		System.out.println(test.peek());
		System.out.println(test.pop());
		System.out.println(test.empty());
		
	}
}
