import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequence {
    public boolean isPossible(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> sequenceMap = new HashMap<>();
        for(int num: nums){
            putEntry(countMap, num, 1);
        }
        for(int num: nums){
            if(!countMap.containsKey(num)){
                continue;
            }
            if(sequenceMap.containsKey(num - 1)){
                putEntry(sequenceMap, num - 1, -1);
                putEntry(sequenceMap, num, 1);
                putEntry(countMap, num, -1);
            }else if(countMap.containsKey(num + 1) && countMap.containsKey(num + 2)){
                putEntry(sequenceMap, num + 2, 1);
                putEntry(countMap, num, -1);
                putEntry(countMap, num + 1, -1);
                putEntry(countMap, num + 2, -1);
            }else {
                return false;
            }
        }
        return true;
    }

    private void putEntry(Map<Integer, Integer> map, int key, int value){
        if(!map.containsKey(key)){
            if(value > 0){
                map.put(key, value);
            }
            return;
        }
        int cur = map.get(key);
        cur += value;
        if(cur > 0){
            map.put(key, cur);
        }else{
            map.remove(key);
        }
    }
}
