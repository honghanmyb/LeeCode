
public class DistinctSubsequence {
	public int numDistinct(String s, String t) {
		if(s == null || t == null || s.length() < t.length()) {
			return 0;
		}
		if(s.length() == t.length()) {
			if(s.equals(t)) {
				return 1;
			}
			return 0;
		}
		
		int[][] numDistinct = new int[t.length()][s.length()];
		int numOfSubsequence = 0;
		char nextElement = t.charAt(0);
		for(int i = 0; i < numDistinct[0].length; i++) {
			if(s.charAt(i) == nextElement) {
				numOfSubsequence++;
			}
			numDistinct[0][i] = numOfSubsequence;
		}
		
		for(int i = 1; i < numDistinct.length; i++) {
			nextElement = t.charAt(i);
			for(int j = 0; j < numDistinct[0].length; j++) {
				if(j < i) {
					numDistinct[i][j] = 0;
					continue;
				}
				char sCurrentElement = s.charAt(j);
				if(sCurrentElement != nextElement) {
					numDistinct[i][j] = numDistinct[i][j - 1];
					continue;
				}
				if(numDistinct[i][j - 1] == 0) {
					numDistinct[i][j] = 1;
				}
				numDistinct[i][j] = numDistinct[i][j - 1] + numDistinct[i - 1][j - 1];
			}
		}
		return numDistinct[numDistinct.length - 1][numDistinct[0].length - 1];
	}
}
