import java.util.*;

public class Parentheses2 {
	public List<String> generateParentheses(int n){
		findAllParenthese("(", 1, 0, n);
		
		return resultList;
	}
	
	private void findAllParenthese(String current, int left, int right, int n) {
		if(current.length() == 2 * n ) {
			if(left == right) resultList.add(current);
			return;
		}
		if(left < n) findAllParenthese(current + "(", left + 1, right, n);
		if(right < left) findAllParenthese(current + ")", left, right + 1, n);
		
	}
	
	List<String> resultList = new ArrayList<String>();
}
