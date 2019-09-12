
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if(s == null || s.equals("")) {
			return true;
		}
		int start = 0, end = s.length() - 1;
		while(start <= end) {
			char startCh = s.charAt(start);
			char endCh = s.charAt(end);
			while(!isValidChar(startCh)) {
				start += 1;
				if(start >= s.length()) {
					break;
				}
				startCh = s.charAt(start);
			}
			while(!isValidChar(endCh)) {
				end -= 1;
				if(end < 0) {
					break;
				}
				endCh = s.charAt(end);
			}
			if(start > end) {
				break;
			}
			if(Character.toLowerCase(startCh) != Character.toLowerCase(endCh)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	private boolean isValidChar(char ch) {
		return ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
	}
}
