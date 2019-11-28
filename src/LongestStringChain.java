import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        if(words.length == 1){
            return 1;
        }
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        int max = 1;
        for(int i = 1; i < words.length; i++){
            int current = 1;
            String currentWord = words[i];
            for(int j = 0; j < currentWord.length(); j++){
                String preWord = currentWord.substring(0, j) + currentWord.substring(j + 1);
                if(map.containsKey(preWord)){
                    current = Math.max(current, map.get(preWord) + 1);
                }
            }
            map.put(currentWord, current);
            max = Math.max(max, current);
        }
        return max;
    }
}
