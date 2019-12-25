import java.util.HashMap;
import java.util.Map;

public class DivideArrayInSetsOfKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0){
            return false;
        }
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            putEntry(map, num, 1);
            min = Math.min(min, num);
        }
        while(!map.isEmpty()){
            System.out.println(min);
            for(int i = 0; i < k; i++){
                if(map.containsKey(min + i)){
                    putEntry(map, min + i, -1);
                }else{
                    return false;
                }
            }
            min = Integer.MAX_VALUE;
            for(int key : map.keySet()){
                min = Math.min(min, key);
            }
        }
        return true;
    }

    private void putEntry(Map<Integer, Integer> map, int key, int change){
        int value = 0;
        if(map.containsKey(key)){
            value = map.get(key);
        }
        value += change;
        if(value > 0){
            map.put(key, value);
        }else{
            map.remove(key);
        }
    }
}
