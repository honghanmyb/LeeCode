import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculatorII {
	public int calculate(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int result = 0;
		boolean shouldPop = false;
		char operatorCh = '*';
		s = s.replaceAll(" ", "");
		Stack<String> stack = new Stack<>();
		int currentIndex = 0, startIndex = 0;
		while(currentIndex < s.length()) {
			char ch = s.charAt(currentIndex);
			if(ch >= '0' && ch <= '9') {
				currentIndex++;
				if(currentIndex >= s.length()) {
					stack.push(s.substring(startIndex, currentIndex));
					if(shouldPop) {
						shouldPop = false;
						int later = Integer.parseInt(stack.pop());
						int previous = Integer.parseInt(stack.pop());
						if(operatorCh == '*') {
							stack.push(Integer.toString(previous * later));
						}else {
							stack.push(Integer.toString(previous / later));
						}
					}
				}
				continue;
			}
			if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				stack.push(s.substring(startIndex, currentIndex));
				currentIndex++;
				startIndex = currentIndex;
				if(shouldPop) {
					shouldPop = false;
					int later = Integer.parseInt(stack.pop());
					int previous = Integer.parseInt(stack.pop());
					if(operatorCh == '*') {
						stack.push(Integer.toString(previous * later));
					}else {
						stack.push(Integer.toString(previous / later));
					}
				}
				if(ch == '+' || ch == '-') {
					stack.push(Character.toString(ch));
				}else {
					shouldPop = true;
					operatorCh = ch;
				}
			}
		}
		if(stack.isEmpty()) {
			return Integer.parseInt(s);
		}
		Stack<String> reversedStack = new Stack<>();
		while(!stack.isEmpty()) {
			reversedStack.push(stack.pop());
		}
		result = Integer.parseInt(reversedStack.pop());
		while(!reversedStack.isEmpty()) {
			String operator = reversedStack.pop();
			int nextNum = Integer.parseInt(reversedStack.pop());
			if(operator.equals("+")) {
				result += nextNum;
			}else {
				result -= nextNum;
			}
		}
		return result;
	}
}
