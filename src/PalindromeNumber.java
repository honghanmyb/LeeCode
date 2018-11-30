
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x < 0) return false;
		String s = (new Integer(x)).toString();
		int head = 0;
		int tail = s.length() - 1;
		while(head < tail) {
			if(s.charAt(head++) != s.charAt(tail--)) {
				return false;
			}
			
		}
		return true;
	}
}
