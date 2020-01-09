import java.util.PriorityQueue;

public class MinCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(sticks.length);
        int cost = 0;
        for(int stick : sticks){
            pq.add(stick);
        }
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int newStick = first + second;
            pq.add(newStick);
            cost += newStick;
        }
        return cost;
    }
}
