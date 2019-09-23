import java.util.Arrays;

public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (point1, point2) -> {
            int dis1 = point1[0] * point1[0] + point1[1] * point1[1];
            int dis2 = point2[0] * point2[0] + point2[1] * point2[1];
            return dis1 - dis2;
        });
        int[][] kClosest = new int[K][2];
        for(int i = 0; i < K; i++){
            kClosest[i] = points[i];
        }
        return kClosest;
    }
}
