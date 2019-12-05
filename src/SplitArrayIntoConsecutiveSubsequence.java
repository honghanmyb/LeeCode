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
                int sequenceCount = sequenceMap.get(num - 1);
                int numCount = countMap.get(num);
                int min = Math.min(sequenceCount, numCount);
                putEntry(sequenceMap, num - 1, -min);
                putEntry(sequenceMap, num, min);
                putEntry(countMap, num, -min);
            }
            if(countMap.containsKey(num)){
                if(countMap.containsKey(num + 1) && countMap.containsKey(num + 2)){
                    int first = countMap.get(num);
                    int second = countMap.get(num + 1);
                    int third = countMap.get(num + 2);
                    if(first > second || first > third){
                        return false;
                    }
                    putEntry(sequenceMap, num + 2, first);
                    putEntry(countMap, num, -first);
                    putEntry(countMap, num + 1, -first);
                    putEntry(countMap, num + 2, -first);
                }else{
                    return false;
                }
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
