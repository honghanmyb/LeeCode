import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, (entry1, entry2) -> entry1.getValue() - entry2.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(pq.size() < k){
                pq.add(entry);
            }else{
                Map.Entry<Integer, Integer> head = pq.peek();
                if(entry.getValue() > head.getValue()){
                    pq.poll();
                    pq.add(entry);
                }
            }
        }
        List<Integer> topKElement = new ArrayList<>(k);
        while(!pq.isEmpty()){
            topKElement.add(pq.poll().getKey());
        }
        return topKElement;
    }
}
