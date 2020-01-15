import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.isEmpty()){
            return 0;
        }
        int curLength = 0, maxLength = 0;
        int curCount = 0;
        int head = 0, tail = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(head <= tail && tail < s.length()){
            if(curCount <= k){
                char curCh = s.charAt(tail++);
                curLength++;
                if(map.containsKey(curCh)){
                    map.put(curCh, map.get(curCh) + 1);
                }else{
                    map.put(curCh, 1);
                    curCount++;
                }
            }else{
                char curCh = s.charAt(head++);
                curLength--;
                int value = map.get(curCh);
                if(value == 1){
                    map.remove(curCh);
                    curCount--;
                }else{
                    map.put(curCh, value - 1);
                }
            }
            if(curCount <= k){
                maxLength = Math.max(curLength, maxLength);
            }
        }
        return maxLength;
    }
}
