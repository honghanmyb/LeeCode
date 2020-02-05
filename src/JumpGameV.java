import java.util.LinkedList;
import java.util.Queue;

public class JumpGameV {
    public int maxJumps(int[] arr, int d) {
        int[] degree = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int count = 0;
            for(int j = i - 1; j >= i - d; j--){
                if(j >= 0 && arr[j] < arr[i]){
                    count++;
                }else{
                    break;
                }
            }
            for(int j = i + 1; j <= i + d; j++){
                if(j < arr.length && arr[j] < arr[i]){
                    count++;
                }else{
                    break;
                }
            }
            degree[i] = count;
        }
        int[] jumps = new int[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 0){
                jumps[i] = 1;
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int curIndex = queue.poll();
            int curMaxJump = 1;
            int curMax = arr[curIndex];
            boolean canJump = true;
            for(int i = 1; i <= d; i++){
                int nextIndex = curIndex - i;
                if(nextIndex < 0){
                    break;
                }
                if(canJump && arr[curIndex] > arr[nextIndex]){
                    curMaxJump = Math.max(curMaxJump, 1 + jumps[nextIndex]);
                }else{
                    canJump = false;
                    if(arr[nextIndex] > curMax){
                        curMax = arr[nextIndex];
                        degree[nextIndex]--;
                        if(degree[nextIndex] == 0){
                            queue.add(nextIndex);
                        }
                    }
                }
            }
            curMax = arr[curIndex];
            canJump = true;
            for(int i = 1; i <= d; i++){
                int nextIndex = curIndex + i;
                if(nextIndex >= arr.length){
                    break;
                }
                if(canJump && arr[curIndex] > arr[nextIndex]){
                    curMaxJump = Math.max(curMaxJump, 1 + jumps[nextIndex]);
                }else{
                    canJump = false;
                    if(arr[nextIndex] > curMax){
                        curMax = arr[nextIndex];
                        degree[nextIndex]--;
                        if(degree[nextIndex] == 0){
                            queue.add(nextIndex);
                        }
                    }
                }
            }
            jumps[curIndex] = curMaxJump;
        }
        int max = 0;
        for(int jump : jumps){
            max = Math.max(jump, max);
        }
        return max;
    }
}
