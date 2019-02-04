import java.util.*;
public class IsomorphicString {
	public boolean isIsomorphic(String s, String t) {
		if(s.length() == 0) return true;
		char[] map1 = new char[256];
		char[] map2 = new char[256];
		for(int i = 0; i < map1.length; i++) {
			map1[i] = 0;
			map2[i] = 0;
		}

		for(int i = 0; i < t.length(); i++) {
			if(map1[s.charAt(i)] == t.charAt(i) && map2[t.charAt(i)] == s.charAt(i)) continue;
			if(map1[s.charAt(i) ] == 0 && map2[t.charAt(i) ] == 0) {
				map1[s.charAt(i) ] = t.charAt(i);
				map2[t.charAt(i) ] = s.charAt(i);
				continue;
			}
			return false;
		}
		return true;
	}
}
