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
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == ' ') {
				continue;
			}
			if(ch >= '0' && ch <= '9') {
				num = num * 10 + ch - '0';
			}else {
				if(shouldPop) {
					shouldPop = false;
					int current = num;
					int previous = stack.pop();
					if(operatorCh == '*') {
						stack.push(previous * current);
					}else {
						stack.push(previous / current);
					}
					num = 0;
				}else {
					stack.push(num);
					num = 0;
				}
				if(ch == '+') {
					stack.add(-1);
				}else if(ch == '-') {
					stack.add(-2);
				}else {
					shouldPop = true;
					operatorCh = ch;
				}
			}
		}
		if(shouldPop) {
			int current = num;
			int previous = stack.pop();
			if(operatorCh == '*') {
				stack.push(previous * current);
			}else {
				stack.push(previous / current);
			}
		}else {
			stack.push(num);
		}

		Stack<Integer> reversedStack = new Stack<>();
		while(!stack.isEmpty()) {
			reversedStack.push(stack.pop());
		}
		result = reversedStack.pop();
		while(!reversedStack.isEmpty()) {
			int operator = reversedStack.pop();
			int nextNum = reversedStack.pop();
			if(operator == -1) {
				result += nextNum;
			}else {
				result -= nextNum;
			}
		}
		return result;
	}
}
