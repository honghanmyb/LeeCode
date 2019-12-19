import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T){
            return 0;
        }
        int[] busCount = new int[routes.length];
        List<Set<Integer>> routesSet = new ArrayList<>(routes.length);
        for(int i = 0; i < routes.length; i++){
            Set newSet = new HashSet<>();
            for(int stop : routes[i]){
                newSet.add(stop);
            }
            routesSet.add(newSet);
        }
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int hop = 2;
        for(int i = 0; i < routes.length; i++){
            if(routesSet.get(i).contains(S)){
                busCount[i] = 1;
                seen.add(S);
                queue.add(i);
            }
        }
        queue.add(-1);
        while(!queue.isEmpty()){
            int currentRoute = queue.poll();
            if(currentRoute == -1){
                if(queue.isEmpty()){
                    break;
                }
                queue.add(-1);
                hop++;
                continue;
            }
            for(int stop : routes[currentRoute]){
                if(seen.contains(stop)){
                    continue;
                }
                seen.add(stop);
                for(int i = 0; i < routes.length; i++){
                    if(busCount[i] > 0){
                        continue;
                    }
                    if(routesSet.get(i).contains(stop)){
                        queue.add(i);
                        busCount[i] = hop;
                    }
                }
            }
        }
        if(!seen.contains(T)){
            return -1;
        }
        int minHop = Integer.MAX_VALUE;
        for(int i = 0; i < routes.length; i++){
            if(routesSet.get(i).contains(T)){
                minHop = Math.min(minHop, busCount[i]);
            }
        }
        return minHop;
    }
}
