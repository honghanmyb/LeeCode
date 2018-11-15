import java.util.*;

public class GroupAnagram {
	public List<List<String>> groupAnagram(String[] strs){
		List<List<String>> result = new ArrayList<List<String>>();
		List<HashMap<Integer, Integer>> mapList = new ArrayList<HashMap<Integer, Integer>>();
		for(int i = 0; i < strs.length; i++) {
			if(containInHashMap(strs[i], mapList, result) == false) {
				List<String> newStringList = new ArrayList<>();
				newStringList.add(strs[i]);
				result.add(newStringList);
				
				HashMap<Integer, Integer> newHashMap = new HashMap<>();
				for(int j = 0; j < strs[i].length(); j++) {
					int cha = strs[i].charAt(j);
					if(newHashMap.containsKey(cha) == true) {
						newHashMap.replace(cha, newHashMap.get(cha)+1);
					}else {
						newHashMap.put(cha, 1);
					}
				}
				mapList.add(newHashMap);
			}
		}
		return result;
	}
	
	private boolean containInHashMap(String s, List<HashMap<Integer, Integer>> mapList, List<List<String>> result) {
		int index = containInNum(mapList, s);
		if(index == -1) return false;
		result.get(index).add(s);
		return true;
	}
	
	private int containInNum(List<HashMap<Integer, Integer>> mapList, String s) {
		HashMap<Integer, Integer> temp = new HashMap<>();
		for(int j = 0; j < s.length(); j++) {
			int cha = s.charAt(j);
			if(temp.containsKey(cha) == true) {
				temp.replace(cha, temp.get(cha)+1);
			}else {
				temp.put(cha, 1);
			}
		}
		for(int i = 0; i < mapList.size(); i++) {
			if(temp.equals(mapList.get(i))) return i;
		}
		return -1;
	}
}
