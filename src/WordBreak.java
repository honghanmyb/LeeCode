import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		//using DP
		boolean[] isBreakable = new boolean[s.length()];
		for(int i = 0; i < isBreakable.length; i++) {
			String subString = s.substring(0, i + 1);
			for(int j = 0; j < wordDict.size(); j++) {
				String word = wordDict.get(j);
				if(subString.equals(word)) {
					isBreakable[subString.length() - 1] = true;
					break;
				}
				if(word.length() < subString.length() && 
						isBreakable[subString.length() - word.length() - 1] == true) {
					if(subString.substring(subString.length() - word.length()).equals(word)) {
						isBreakable[i] = true;
						break;
					}
				}
			}
		}
		
		return isBreakable[s.length() - 1];
	}
}
