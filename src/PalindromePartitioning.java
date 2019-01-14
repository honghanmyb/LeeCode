import java.util.*;

public class PalindromePartitioning {
	public List<List<String>> partition(String s){
		List<List<String>> result = new ArrayList<>();
		if(s == null || s.length() == 0) return result;
		if(s.length() == 1) {
			List<String> stringList = new ArrayList<>();
			stringList.add(s);
			result.add(stringList);
			return result;
		}
		for(int i = s.length() - 1; i >= 0; i--) {
			String firstPalin = s.substring(i, s.length());
			if(isPalindrome(firstPalin)) {
				List<List<String>> remainLists = partition(s.substring(0, i));
				if(remainLists.size() == 0) {
					List<String> stringList = new ArrayList<>();
					stringList.add(firstPalin);
					result.add(stringList);
					continue;
				}
				for(int j = 0; j < remainLists.size(); j++) {
//					remainLists.get(j).add(0, firstPalin);
					remainLists.get(j).add(firstPalin);
					result.add(remainLists.get(j));
				}

			}
		}
		return result;
		
	}
	
	private boolean isPalindrome(String s) {
		int head = 0;
		int tail = s.length() - 1;
		while(head <= tail) {
			if(s.charAt(head++) != s.charAt(tail--)) return false;
		}
		return true;
	}
}
