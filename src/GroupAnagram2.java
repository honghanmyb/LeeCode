import java.util.*;

public class GroupAnagram2 {
	public List<List<String>> groupAnagram(String[] strs){
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<Integer, List<String>> map = new HashMap<>();
		for(int i = 0; i < strs.length; i++) {
			int currentCode = charCode(strs[i]);
	
			if(map.containsKey(currentCode)) {
				map.get(currentCode).add(strs[i]);
				continue;
			}else {
				List<String> newStrings = new ArrayList<>();
				newStrings.add(strs[i]);
				map.put(currentCode, newStrings);
				result.add(newStrings);
			}
		}
		return result;
	}
	
	private int charCode(String s) {
	
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		int code = 0;
		for(int i = 0; i < temp.length; i++) {
			code = code * 26 + temp[i] - 'a' + 1;
		}
		return code;
	}
}
