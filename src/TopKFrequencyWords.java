import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequencyWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            }else{
                map.put(word, 1);
            }
        }
        PriorityQueue<Map.Entry> heap = new PriorityQueue<>(k, (entry1, entry2) -> {
            if(entry1.getValue() == entry2.getValue()){
                return ((String)entry2.getKey()).compareTo((String)entry1.getKey());
            }
            return (int)entry1.getValue() - (int)entry2.getValue();
        });
        for(Map.Entry entry : map.entrySet()){
            if(heap.size() < k){
                heap.add(entry);
                continue;
            }
            Map.Entry minEntry = heap.peek();
            if((int)minEntry.getValue() < (int)entry.getValue() || (int)minEntry.getValue() == (int)entry.getValue() && ((String)minEntry.getKey()).compareTo((String)entry.getKey()) > 0){
                heap.poll();
                heap.add(entry);
            }
        }
        List<String> temp = new ArrayList<>();
        while(!heap.isEmpty()){
            temp.add(((String)heap.poll().getKey()));
        }
        List<String> topKWords = new ArrayList<>(temp.size());
        for(int i = temp.size() - 1; i >= 0; i--){
            topKWords.add(temp.get(i));
        }
        return topKWords;
    }
}
