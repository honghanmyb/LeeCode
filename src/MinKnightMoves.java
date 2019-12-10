import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinKnightMoves {
    public int minKnightMoves(int x, int y) {
        int count = 0;
        x = Math.abs(x);
        y = Math.abs(y);
        int startX = 0, startY = 0;
        int[][] dirs = new int[][]{{2,1},{2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1,-2}};
        while(x - startX > 4 || y - startY > 4){
            if(x - startX > y - startY){
                startX += 2;
                if(y > startY){
                    startY += 1;
                }else{
                    startY -= 1;
                }
                count++;
            }else{
                if(x > startX){
                    startX += 1;
                }else{
                    startX -= 1;
                }
                startY += 2;
                count++;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int[] flag = new int[0];
        queue.add(new int[]{startX, startY});
        queue.add(flag);
        set.add(startX + "," + startY);
        while(true){
            int[] current = queue.poll();
            if(current == flag){
                count++;
                queue.add(flag);
                continue;
            }
            int curX = current[0];
            int curY = current[1];
            if(curX == x && curY == y){
                break;
            }
            for(int[] direction : dirs){
                int newX = curX + direction[0];
                int newY = curY + direction[1];
                if(Math.abs(x - newX) < 4 && Math.abs(y - newY) < 4){
                    if(set.add(newX + "," + newY)){
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        return count;
    }
}
