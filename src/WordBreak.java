import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		if(containOnlyDots(s)) {
			return true;
		}
		List<String> filteredWordDict = new ArrayList<>();
		for(String word: wordDict) {
			if(s.contains(word)) {
				filteredWordDict.add(word);
			}
		}
		System.out.println(filteredWordDict.toString());
		for(String word: filteredWordDict) {
			int indexOfWord = s.indexOf(word);
			if(indexOfWord == -1) {
				continue;
			}
//			String newString = s.substring(0, indexOfWord) + "." + s.substring(indexOfWord + word.length());
			String newString = s.replace(word, ".");
			filteredWordDict.remove(word);
			if(wordBreak(newString, filteredWordDict)) {
				return true;
			}
			filteredWordDict.add(word);
		}
		return false;
	}
	
	private boolean containOnlyDots(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != '.') {
				return false;
			}
		}
		
		return true;
	}
}
