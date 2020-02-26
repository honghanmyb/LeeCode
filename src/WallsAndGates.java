import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] directions = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        int[] flag = new int[]{};
        queue.add(flag);
        int curDist = 0;
        while(true){
            int[] pos = queue.poll();
            if(pos == flag){
                if(queue.isEmpty()){
                    break;
                }
                curDist++;
                queue.add(flag);
                continue;
            }
            for(int[] direction : directions){
                int row = pos[0] + direction[0];
                int col = pos[1] + direction[1];
                if(row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length){
                    continue;
                }
                if(rooms[row][col] == Integer.MAX_VALUE){
                    rooms[row][col] = curDist + 1;
                    queue.add(new int[]{row, col});
                }
            }
        }
    }
}
