import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("!|\\?|'|,|;|\\.| ");
        for(int i = 0; i < words.length; i++){
            words[i] = words[i].toLowerCase();
        }
        Set<String> set = new HashSet<>();
        for(String bannedWord: banned){
            set.add(bannedWord);
        }
        set.add("");
        String commonWord = "";
        int occurTimes = 0;
        Map<String, Integer> wordToFrequency = new HashMap<>();
        for(String word: words){
            if(set.contains(word)){
                continue;
            }
            int currentTime = 0;
            if(wordToFrequency.containsKey(word)){
                currentTime = wordToFrequency.get(word);
                currentTime += 1;
                wordToFrequency.put(word, currentTime);
            }else{
                wordToFrequency.put(word, 1);
                currentTime = 1;
            }
            if(occurTimes < currentTime){
                occurTimes = currentTime;
                commonWord = word;
            }
        }
        return commonWord;
    }
}
