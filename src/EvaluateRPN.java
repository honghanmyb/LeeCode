import java.util.Stack;

public class EvaluateRPN {
	public int evalRPN(String[] tokens) {
		if(tokens.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		int firstInt, secondInt;
		for(String token: tokens) {
			if(token.equals("+")) {
				secondInt = stack.pop();
				firstInt = stack.pop();
				stack.add(firstInt + secondInt);
			}else if(token.equals("-")) {
				secondInt = stack.pop();
				firstInt = stack.pop();
				stack.add(firstInt - secondInt);
			}else if(token.equals("*")) {
				secondInt = stack.pop();
				firstInt = stack.pop();
				stack.add(firstInt * secondInt);
			}else if(token.equals("/")) {
				secondInt = stack.pop();
				firstInt = stack.pop();
				stack.add(firstInt / secondInt);
			}else {
				stack.add(Integer.parseInt(token));
			}
		}
		
		return stack.peek();
	}
}
