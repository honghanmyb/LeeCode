import java.util.Arrays;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if(t.isEmpty() || s.isEmpty()) {
			return "";
		}
		int[] chars = new int[256];
		for(int i = 0; i < t.length(); i++) {
			chars[t.charAt(i)]++;
		}
		int head = 0, tail = 0;
		String minString = s;
		String currentString = s.substring(head, tail);
		boolean findWindow = false;
		while(true) {
			if(!findWindow) {
				if(tail >= s.length()) {
					break;
				}
				char currentCh = s.charAt(tail++);
				currentString += currentCh;
				if(t.indexOf(currentCh) >= 0) {
					chars[currentCh]--;
					if(findWindow(chars, t)) {
						findWindow = true;
						minString = minString.length() > currentString.length()? currentString: minString;
						continue;
					}
				}
			}else {
				char currentCh = s.charAt(head++);
				currentString = currentString.substring(1);
				if(t.indexOf(currentCh) >= 0) {
					chars[currentCh]++;
					if(chars[currentCh] > 0) {
						findWindow = false;
						continue;
					}
				}
				minString = minString.length() > currentString.length()? currentString: minString;
			}
		}
		if(head == 0) {
			return "";
		}
		return minString;
	}
	
	private boolean findWindow(int[] chars, String t) {
		for(int i = 0; i < t.length(); i++) {
			if(chars[t.charAt(i)] > 0) {
				return false;
			}
		}
		return true;
	}
}
