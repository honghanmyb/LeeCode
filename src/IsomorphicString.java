import java.util.*;
public class IsomorphicString {
	public boolean isIsomorphic(String s, String t) {
		if(s.length() == 0) return true;
		HashMap<Character, Character> map1 = new HashMap<>();
		HashMap<Character, Character> map2 = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(!map1.containsKey(s.charAt(i)) && !map2.containsKey(t.charAt(i))) {
				map1.put(s.charAt(i), t.charAt(i));
				map2.put(t.charAt(i), s.charAt(i));
				continue;
			}
			if((map1.containsKey(s.charAt(i)) && map2.containsKey(t.charAt(i))) == false) return false;
			if(s.charAt(i) == map2.get(t.charAt(i)) &&
					t.charAt(i) == map1.get(s.charAt(i))) continue;
			
			return false;
		}
		return true;
	}
}
