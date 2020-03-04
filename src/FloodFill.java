import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor == newColor){
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        queue.add(new int[]{sr, sc});
        while(!queue.isEmpty()){
            int[] curCell = queue.poll();
            image[curCell[0]][curCell[1]] = newColor;
            for(int[] direction : directions){
                int newRow = curCell[0] + direction[0];
                int newCol = curCell[1] + direction[1];
                if(newRow < 0 || newRow >= image.length || newCol < 0 || newCol >= image[0].length) continue;
                if(image[newRow][newCol] == oldColor){
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
        return image;
    }
}
