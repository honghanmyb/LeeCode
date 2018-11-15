import java.util.*;
public class MyQueue {
	public MyQueue() {
		//constructor
		stack1 = new Stack<>();
		stack2 = new Stack<>();
		
	}
	
	public void push(int x) {
		stack1.push(x);
		
	}
	
	public int pop() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int returnValue = stack2.pop();
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return returnValue;
	}
	
	public boolean empty() {
		
		return stack1.isEmpty();
	}
	
	public int peek() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int returnValue = stack2.peek();
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return returnValue;
	}
	
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
}
