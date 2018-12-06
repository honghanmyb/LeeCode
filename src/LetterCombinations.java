import java.util.*;
public class LetterCombinations {
	
	public LetterCombinations() {
		refer = new HashMap<Character, String[]>();
		refer.put('2', two);
		refer.put('3', three);
		refer.put('4', four);
		refer.put('5', five);
		refer.put('6', six);
		refer.put('7', seven);
		refer.put('8', eight);
		refer.put('9', nine);
	}
	
	public List<String> letterCombinations (String digits){
		List<String> result = new ArrayList<>();
		if(digits.length() == 0) return result;
		String[] chars = refer.get(digits.charAt(digits.length() - 1));
		if(digits.length() == 1) {

			for(int i = 0; i < chars.length; i++) {
				result.add(chars[i]);
			}
			
			return result;
		}

		List<String> lastResult = letterCombinations(digits.substring(0, digits.length() - 1));
		for(int i = 0; i < chars.length; i++) {
			for(int j = 0; j < lastResult.size(); j++) {
				result.add(lastResult.get(j) + chars[i]);
			}
		}
		
		return result;
	}

	String[] two = {"a", "b", "c"};
	String[] three = {"d", "e", "f"};
	String[] four = {"g", "h", "i"};
	String[] five = {"j", "k", "l"};
	String[] six = {"m", "n", "o"};
	String[] seven = {"p", "q", "s", "t"};
	String[] eight = {"t", "u", "v"};
	String[] nine = {"w", "x", "y", "z"};
	HashMap<Character, String[]> refer;
}
