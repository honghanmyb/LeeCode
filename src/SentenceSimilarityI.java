import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarityI {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : pairs) {
            String first = pair.get(0);
            String second = pair.get(1);
            addPairToMap(first, second, map);
            addPairToMap(second, first, map);
        }

        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            if (word1.equals(word2)) {
                continue;
            }
            if (map.containsKey(word1) && map.get(word1).contains(word2)) {
                continue;
            }
            return false;
        }
        return true;
    }

    private void addPairToMap(String key, String val, Map<String, Set<String>> map) {
        if (map.containsKey(key)) {
            map.get(key).add(val);
        } else {
            Set<String> set = new HashSet<>();
            set.add(val);
            map.put(key, set);
        }
    }
}
