import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeToHalf {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> numToTimes = new HashMap<>();
        for(int num : arr){
            if(numToTimes.containsKey(num)){
                numToTimes.put(num, numToTimes.get(num) + 1);
            }else{
                numToTimes.put(num, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(numToTimes.size(), (int1, int2) -> int2 - int1);
        pq.addAll(numToTimes.values());
        int size = 0, count = 0;
        while(count < arr.length / 2){
            count += pq.poll();
            size++;
        }
        return size;
    }
}
