
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		if(strs.length == 1) {
			return strs[0];
		}
		int smallestLength = Integer.MAX_VALUE;
		for(String s: strs) {
			smallestLength = Math.min(smallestLength, s.length());
		}
		String longestCommonPrefix = "";
		boolean shouldStop = false;
		for(int i = 0; i < smallestLength; i++) {
			char currentCh = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++) {
				if(strs[j].charAt(i) != currentCh) {
					shouldStop = true;
					break;
				}
			}
			if(shouldStop) {
				break;
			}
			longestCommonPrefix += currentCh;
		}
		return longestCommonPrefix;
	}
}
