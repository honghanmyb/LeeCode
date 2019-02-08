
public class EditDistance {
	public int minDistance(String word1, String word2) {
		if(word1 == null) return 0;
		if(word2 == null) return 0;
		if(word1.length() == 0) return word2.length();
		if(word2.length() == 0) return word1.length();
		int[][] costTable = new int[word1.length()][word2.length()];
		boolean firstTimeEqual = false;
//		if(word1.charAt(0) == word2.charAt(0)) {
//			costTable[0][0] = 0;
//		}else {
//			costTable[0][0] = 1;
//		}
		
		for(int i = 0; i < word1.length(); i++) {
			if(!firstTimeEqual) {
				if(word1.charAt(i) == word2.charAt(0)) {
					if(i == 0) costTable[i][0] = 0;
					else costTable[i][0] = costTable[i - 1][0];
					firstTimeEqual = true;
					continue;
				}
			}
			if(i > 0) {
				costTable[i][0] = costTable[i-1][0] + 1;
			}else {
				costTable[i][0] = 1;
			}

		}
		
		firstTimeEqual = false;
		for(int j = 0; j < word2.length(); j++) {
			if(!firstTimeEqual) {
				if(word2.charAt(j) == word1.charAt(0)) {
					if(j == 0) costTable[0][j] = 0;
					else costTable[0][j] = costTable[0][j - 1];
					firstTimeEqual = true;
					continue;
				}
			}
			if(j > 0) {
				costTable[0][j] = costTable[0][j - 1] + 1;
			}else {
				costTable[0][j] = 1;
			}
		}
		
		for(int i = 1; i < word1.length(); i++) {
			for(int j = 1; j < word2.length(); j++) {
				if(word1.charAt(i) == word2.charAt(j)) {
					costTable[i][j] = costTable[i - 1][j - 1];
				}else {
					costTable[i][j] = 1 + Math.min(Math.min(costTable[i - 1][j - 1], costTable[i - 1][j]),
							costTable[i][j - 1]);
				}
			}
		}
		return costTable[word1.length() - 1][word2.length() - 1];
	}
}
