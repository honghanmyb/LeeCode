
public class ValidAnagram {
	public boolean isAnagram(String t, String s) {
		if(t.length() != s.length()) return false;
		int[][] record = new int[26][2];
		for(int i =0; i < s.length(); i++) {
			record[s.charAt(i) - 'a'][0]++;
			record[t.charAt(i) - 'a'][1]++;
		}
		for(int i = 0; i < 26; i++) {
			if(record[i][0] != record[i][1]) return false;
		}
		return true;
	}
}
