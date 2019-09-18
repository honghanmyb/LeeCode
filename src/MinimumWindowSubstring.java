import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if(t.isEmpty() || s.isEmpty()) {
			return "";
		}
		Set<Character> tSet = new HashSet<>();
		int[] chars = new int[256];
		for(int i = 0; i < t.length(); i++) {
			chars[t.charAt(i)]++;
			tSet.add(t.charAt(i));
		}
		int head = 0, tail = 0;
		int[] minStringRecord = new int[] {0, s.length() - 1};
		int[] currentStringRecord = new int[] {head, tail};
		
		boolean findWindow = false;
		while(true) {
			if(!findWindow) {
				if(tail >= s.length()) {
					break;
				}
				currentStringRecord[1] = tail;
				char currentCh = s.charAt(tail++);
				if(tSet.contains(currentCh)) {
					chars[currentCh]--;
					if(findWindow(chars, t)) {
						findWindow = true;
						if(minStringRecord[1] - minStringRecord[0] > currentStringRecord[1] - currentStringRecord[0]) {
							minStringRecord[0] = currentStringRecord[0];
							minStringRecord[1] = currentStringRecord[1];
						}
						continue;
					}
				}
			}else {
				char currentCh = s.charAt(head++);
				currentStringRecord[0] = head;
				if(tSet.contains(currentCh)) {
					chars[currentCh]++;
					if(chars[currentCh] > 0) {
						findWindow = false;
						continue;
					}
				}
				if(minStringRecord[1] - minStringRecord[0] > currentStringRecord[1] - currentStringRecord[0]) {
					minStringRecord[0] = currentStringRecord[0];
					minStringRecord[1] = currentStringRecord[1];
				}
			}
		}
		if(head == 0) {
			return "";
		}
		return s.substring(minStringRecord[0], minStringRecord[1] + 1);
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
