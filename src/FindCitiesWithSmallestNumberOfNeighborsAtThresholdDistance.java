import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FindCitiesWithSmallestNumberOfNeighborsAtThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int minCity = -1;
        int minNumber = n;
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(graph[i], 20000);
            graph[i][i] = 0;
        }
        for(int[] edge : edges){
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        for(int i = 0; i < n; i++){
            int curNum = findNum(i, graph, distanceThreshold, minNumber);
            if(curNum <= minNumber){
                minNumber = curNum;
                minCity = i;
            }
        }
        return minCity;
    }

    private int findNum(int startCity, int[][] graph, int maxDist, int minNumber){
        Set<Integer> findCities = new HashSet<>();
        findCities.add(startCity);
        PriorityQueue<int[]> dists = new PriorityQueue<>(graph.length, (edge1, edge2) -> edge1[1] - edge2[1]);
        for(int i = 0; i < graph.length; i++){
            if(i != startCity){
                dists.add(new int[]{i, graph[startCity][i]});
            }
        }
        while(!dists.isEmpty()){
            if(findCities.size() - 1 > minNumber){
                return minNumber + 1;
            }
            int[] minEdge = dists.poll();
            if(findCities.contains(minEdge[0])){
                continue;
            }
            int minCity = minEdge[0];
            int curDist = minEdge[1];
            if(curDist > maxDist){
                break;
            }
            findCities.add(minCity);
            for(int i = 0; i < graph.length; i++){
                if(!findCities.contains(i) && graph[startCity][i] > curDist + graph[minCity][i]){
                    int newDist = curDist + graph[minCity][i];
                    graph[startCity][i] = newDist;
                    graph[i][startCity] = newDist;
                    dists.add(new int[]{i, newDist});
                }
            }
        }
        return findCities.size() - 1;
    }
}
