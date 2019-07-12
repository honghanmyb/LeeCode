import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch (ch) {
			case '(':
			case '[':
			case '{':{
				stack.push(ch);
				break;
			}
			case ')':{
				if(valid('(', stack)) {
					break;
				}
				return false;
			}
			case ']':{
				if(valid('[', stack)) {
					break;
				}
				return false;
			}
			case '}': {
				if(valid('{', stack)) {
					break;
				}
				return false;
			}
			}
		}
		if(stack.isEmpty()) return true;
		return false;
	}
	
	private boolean valid(char target, Stack<Character> stack) {
		if(stack.isEmpty()) return false;
		if(stack.peek() != target) return false;
		stack.pop();
		return true;
	}

}
