import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (arr1, arr2) -> {
            return arr1[0] - arr2[0];
        });
        if(intervals.length == 0){
            return 0;
        }
        PriorityQueue<int[]> pq = new PriorityQueue(intervals.length, (arr1, arr2) -> {
            return ((int[])arr1)[1] - ((int[])arr2)[1];
        });
        int maxNum = 0;
        int currentNum = pq.size();
        for(int[] interval: intervals){
            while(!pq.isEmpty() && pq.peek()[1] <= interval[0]){
                pq.poll();
            }
            pq.add(interval);
            currentNum = pq.size();
            maxNum = Integer.max(maxNum, currentNum);
        }
        return maxNum;
    }
}
