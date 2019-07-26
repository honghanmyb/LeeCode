import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if(pattern == null || str == null) {
			return false;
		}
		char[] patternChar = pattern.toCharArray();
		String[] strWords = str.split(" ");
		if(patternChar.length != strWords.length) {
			return false;
		}
		Map<Character, String> patternMap = new HashMap<>();
		Set<String> strWordSet = new HashSet<>();
		
		for(int i = 0; i < patternChar.length; i++) {
			char currentPatternChar = patternChar[i];
			String currentStrWord = strWords[i];
			if(patternMap.containsKey(currentPatternChar)) {
				if(!patternMap.get(currentPatternChar).equals(currentStrWord)) {
					return false;
				}
				continue;
			}
			
			if(strWordSet.contains(currentStrWord)) {
				return false;
			}
			patternMap.put(currentPatternChar, currentStrWord);
			strWordSet.add(currentStrWord);
		}
		
		return true;
	}
}
