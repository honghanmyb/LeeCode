import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsOA {
    public int[][] kClosest(int[][] points, int K) {
        if(K == points.length){
            return points;
        }
        List<Point> pointElements = new ArrayList<>(points.length);
        for(int[] point : points){
            pointElements.add(new Point(point[0], point[1]));
        }
        PriorityQueue<Point> pq = new PriorityQueue<>(K, (point1, point2) -> {
           return point2.dist - point1.dist; 
        });
        for(Point point: pointElements){
            if(pq.size() < K){
                pq.add(point);
                continue;
            }
            Point maxPoint = pq.peek();
            if(maxPoint.dist > point.dist){
                pq.poll();
                pq.add(point);
            }
        }
        int[][] kPoints = new int[K][2];
        for(int i = 0; i < kPoints.length; i++){
            Point curPoint = pq.poll();
            kPoints[i][0] = curPoint.x;
            kPoints[i][1] = curPoint.y;
        }
        return kPoints;
    }
    
    private class Point{
        public int x;
        public int y;
        public int dist;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.dist = x * x + y * y;
        }
    }
}
