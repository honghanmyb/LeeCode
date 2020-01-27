import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        int sum = 0;
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++){
            if(A[i] >= K){
                return 1;
            }
            sum += A[i];
            A[i] = sum;
        }
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < A.length; i++){
            while(!queue.isEmpty() && A[queue.peekLast()] > A[i]){
                queue.pollLast();
            }
            if(A[i] >= K){
                shortest = Math.min(shortest, i + 1);
            }
            while(!queue.isEmpty() && A[i] - A[queue.peekFirst()] >= K){
                shortest = Math.min(shortest, i - queue.pollFirst());
            }
            queue.addLast(i);
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}
