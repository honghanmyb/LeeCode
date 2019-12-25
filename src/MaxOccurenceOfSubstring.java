import java.util.HashMap;
import java.util.Map;

public class MaxOccurenceOfSubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int count = 0;
            int[] record = new int[26];
            for(int j = 0; j < maxSize; j++){
                if(i + j >= s.length()){
                    break;
                }
                if(record[s.charAt(i + j) - 'a'] == 0){
                    record[s.charAt(i + j) - 'a'] = 1;
                    count++;
                    if(count > maxLetters){
                        break;
                    }
                }
                if(j + 1 >= minSize && j + 1 <= maxSize){
                    String curS = s.substring(i, i + j + 1);
                    if(map.containsKey(curS)){
                        map.put(curS, map.get(curS) + 1);
                    }else{
                        map.put(curS, 1);
                    }
                }
            }
        }
        int maxCount = 0;
        for(Map.Entry entry : map.entrySet()){
            maxCount = Math.max(maxCount, (int)entry.getValue());
        }
        return maxCount;
    }
}
