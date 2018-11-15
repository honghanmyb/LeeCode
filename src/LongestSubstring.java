import java.util.*;
public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> record = new HashMap<Character, Integer>();
		int max = 0;int temp = 0; int leastIndex = -1;
		for(int i = 0; i < s.length(); i++) {
			if(record.containsKey(s.charAt(i))) {
				if(  record.get(s.charAt(i)) > leastIndex) {
					if(temp > max) max = temp;
					temp = i - record.get(s.charAt(i));
					leastIndex = i - temp;
					record.put(s.charAt(i), i);
				}else {
					record.put(s.charAt(i), i);
					temp++;
				}
			}else {
				record.put(s.charAt(i), i);
				temp++;
			}
		}
		if(temp > max) max = temp;
		return max; 
	}
}
