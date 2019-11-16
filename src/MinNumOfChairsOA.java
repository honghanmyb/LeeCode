import java.util.Arrays;
import java.util.PriorityQueue;

public class MinNumOfChairsOA {
    public int minNumOfChairs(int[] S, int[] E) {
    	int[][] guests = new int[S.length][2];
    	for(int i = 0; i < S.length; i++) {
    		guests[i][0] = S[i];
    		guests[i][1] = E[i];
    	}
        Arrays.sort(guests, (arr1, arr2) -> {
            return arr1[0] - arr2[0];
        });
        if(guests.length == 0){
            return 0;
        }
        PriorityQueue<int[]> pq = new PriorityQueue(guests.length, (arr1, arr2) -> {
            return ((int[])arr1)[1] - ((int[])arr2)[1];
        });
        int maxNum = 0;
        int currentNum = pq.size();
        for(int[] interval: guests){
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
