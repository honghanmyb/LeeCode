import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count++;
                }
                if(grid[i][j] == 2){
                    queue.add(new Point(i, j));
                }
            }
        }
        if(count == 0){
            return 0;
        }
        if(queue.isEmpty()){
            return -1;
        }
        Point mark = new Point(-1, -1);
        queue.add(mark);
        int minute = 0;
        while(queue.size() > 1){
            Point next = queue.poll();
            int x = next.x;
            int y = next.y;
            if(next == mark){
                minute++;
                queue.add(mark);
                continue;
            }
            if(x > 0 && grid[x - 1][y] == 1){
                grid[x - 1][y] = 2;
                count--;
                queue.add(new Point(x - 1, y));
            }
            if(x < grid.length - 1 && grid[x + 1][y] == 1){
                grid[x + 1][y] = 2;
                count--;
                queue.add(new Point(x + 1, y));
            }
            if(y > 0 && grid[x][y - 1] == 1){
                grid[x][y - 1] = 2;
                count--;
                queue.add(new Point(x, y - 1));
            }
            if(y < grid[0].length - 1 && grid[x][y + 1] == 1){
                grid[x][y + 1] = 2;
                count--;
                queue.add(new Point(x, y + 1));
            }
        }
        if(count > 0){
            return -1;
        }
        return minute;
    }
    
    private class Point{
        public int x;
        public int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
