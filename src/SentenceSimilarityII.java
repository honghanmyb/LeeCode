import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length){
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for(List<String> pair : pairs){
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            if(word1.equals(word2)){
                continue;
            }
            if(!map.containsKey(word1)){
                Set<String> set = new HashSet<>();
                set.add(word1);
                map.put(word1, set);
            }
            if(!map.containsKey(word2)){
                Set<String> set = new HashSet<>();
                set.add(word2);
                map.put(word2, set);
            }
            union(map, word1, word2);
        }
        for(int i = 0; i < words1.length; i++){
            String word1 = words1[i];
            String word2 = words2[i];
            if(word1.equals(word2)){
                continue;
            }
            Set<String> set1 = map.get(word1);
            Set<String> set2 = map.get(word2);
            if(set1 != null &&set2 != null && set1 == set2){
                continue;
            }
            return false;
        }
        return true;
    }

    private void union(Map<String, Set<String>> map, String word1, String word2){
        Set<String> set1 = map.get(word1);
        Set<String> set2 = map.get(word2);
        if(set1 == set2){
            return;
        }
        Set<String> unionSet = set1.size() > set2.size() ? set1 : set2;
        Set<String> sourceSet = set1.size() > set2.size() ? set2 : set1;
        unionSet.addAll(sourceSet);
        for(String word : sourceSet){
            map.put(word, unionSet);
        }
        map.put(word1, unionSet);
        map.put(word2, unionSet);
    }
}
