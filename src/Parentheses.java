/*
 * Backtracking in a less effective way, that is to say, this algorithm judges all the conditions manually,
 * while it is possible to let the computer go through all the possible outcomes without interference.
 * Details see Patrenthese2.
 */

import java.util.*;
public class Parentheses {
	public List<String> generateParentheses(int n){
		StringTreeNode root = new StringTreeNode("(");
		root.depth = 1;
		this.n = n;
		findAllParentheses(root);
		return resultList;
	}
	
	private void findAllParentheses(StringTreeNode root) {
		if(root != null) {
			int flag = calculateFlag(root);
			if(!isWellForm(flag)) {
				root = null;
				return;
			}
			
			if(root.depth == 2 * n ) {
				if(flag == 0) {
					resultList.add(root.s);
				}
				root = null;
				return ;
			}
			
			root.left = new StringTreeNode(root.s + "(");
			root.left.depth = root.depth + 1;
			findAllParentheses(root.left);
			
			root.right = new StringTreeNode(root.s + ")");
			root.right.depth = root.depth + 1;
			findAllParentheses(root.right);
		}
	}
	
	private int calculateFlag(StringTreeNode root) {
		int flag = 0;
		for(int i = 0; i < root.s.length(); i++) {
			if(root.s.charAt(i) == '(') flag++;
			else if(root.s.charAt(i) == ')') flag--;
		}
		return flag;
	}
	
	private boolean isWellForm(int flag) {
		if(flag >=0 && flag <= n) return true;
		return false;
	}
	private ArrayList<String> resultList =new ArrayList<String>();
	private int n;
}
