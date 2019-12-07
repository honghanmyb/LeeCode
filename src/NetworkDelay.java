import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NetworkDelay {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N + 1][N + 1];
        for(int[] row : graph){
            Arrays.fill(row, -1);
        }
        for(int[] time : times){
            graph[time[0]][time[1]] = time[2];
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] timeRecord = new int[N + 1];
        Arrays.fill(timeRecord, -1);
        timeRecord[K] = 0;
        queue.add(K);
        int count = 1;
        int flagNum = Integer.MAX_VALUE;
        int maxTime = 0;
        queue.add(flagNum);
        while(true){
            int current = queue.poll();
            if(current == flagNum){
                if(queue.isEmpty()){
                    break;
                }
                queue.add(flagNum);
                continue;
            }
            for(int i = 1; i <= N; i++){
                if(i == current){
                    continue;
                }
                if(graph[current][i] == -1){
                    continue;
                }
                int nextVal = timeRecord[current] + graph[current][i];
                if(timeRecord[i] == -1){
                    timeRecord[i] = nextVal;
                    queue.add(i);
                    count++;
                }else if(timeRecord[i] > nextVal){
                    timeRecord[i] = nextVal;
                    queue.add(i);
                }
            }
        }
        if(count < N){
            return -1;
        }
        for(int record : timeRecord){
            maxTime = Math.max(maxTime, record);
        }
        return maxTime;
    }
}
