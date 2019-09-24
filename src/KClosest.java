import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        List<int[]> dists = new ArrayList<>(points.length);
        for(int i = 0; i < points.length; i++){
            int[] dist = new int[2];
            dist[0] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            dist[1] = i;
            dists.add(dist);
        }
        int kDist = quickSelect(dists, K);
        int[][] kClosest = new int[K][2];
        int count = 0;
        for(int[] dist: dists){
            if(dist[0] <= kDist){
                kClosest[count++] = points[dist[1]];
            }
        }
        return kClosest;
    }
    
    private int quickSelect(List<int[]> dists, int K){
        List<int[]> small = new ArrayList<>();
        List<int[]> large = new ArrayList<>();
        int[] flagElement = dists.get(dists.size() - 1);
        for(int[] dist: dists){
            if(dist == flagElement){
                continue;
            }
            if(dist[0] <= flagElement[0]){
                small.add(dist);
            }else{
                large.add(dist);
            }
        }
        if(small.size() > K - 1){
            return quickSelect(small, K);
        }
        if(small.size() < K - 1){
            return quickSelect(large, K - small.size() - 1);
        }else{
            return flagElement[0];
        }
    }
}
