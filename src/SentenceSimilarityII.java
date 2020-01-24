import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length){
            return false;
        }
        Map<String, Integer> wordToId = new HashMap<>();
        int id = 0;
        for(List<String> pair : pairs){//get total word count, index word to map
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            if(word1.equals(word2)){
                continue;
            }
            id = addIdToMap(word1, id, wordToId);
            id = addIdToMap(word2, id, wordToId);
        }

        int[] ids = new int[id + 1];//initial setup
        for(int i = 0; i < ids.length; i++){
            ids[i] = i;
        }

        for(List<String> pair : pairs){
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            if(word1.equals(word2)){
                continue;
            }
            int id1 = wordToId.get(word1);
            int id2 = wordToId.get(word2);
            union(id1, id2, ids);
        }
        for(int i = 0; i < words1.length; i++){
            String word1 = words1[i];
            String word2 = words2[i];
            if(word1.equals(word2)){
                continue;
            }
            if(!wordToId.containsKey(word1) || !wordToId.containsKey(word2)){
                return false;
            }
            int id1 = wordToId.get(word1);
            int id2 = wordToId.get(word2);
            if(getFather(ids, id1) != getFather(ids, id2)){
                return false;
            }
        }
        return true;
    }

    private void union(int id1, int id2, int[] ids){
        int id1Father = getFather(ids, id1);
        int id2Father = getFather(ids, id2);
        ids[Math.max(id1Father, id2Father)] = Math.min(id1Father, id2Father);
    }

    private int getFather(int[] ids, int id){
        if(ids[id] == id){
            return id;
        }
        ids[id] = getFather(ids, ids[id]);
        return ids[id];
    }

    private int addIdToMap(String word, int curId, Map<String, Integer> map){
        if(map.containsKey(word)){
            return curId;
        }
        map.put(word, curId);
        return curId + 1;
    }
}
