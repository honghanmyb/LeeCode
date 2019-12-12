import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WaterDistributionInVillage {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>(pipes.length + n);
        for(int i = 0; i < wells.length; i++){
            edges.add(new int[]{0, i + 1, wells[i]});
        }
        for(int[] pipe : pipes){
            edges.add(pipe);
        }
        edges.sort((edge1, edge2) -> edge1[2] - edge2[2]);
        int[] rootId = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            rootId[i] = i;
        }
        int total = 0;
        int treeEdgeCount = 0;
        for(int[] edge : edges){
            int firstNode = edge[0];
            int secondNode = edge[1];
            int cost = edge[2];
            int root1 = getRoot(rootId, firstNode);
            int root2 = getRoot(rootId, secondNode);
            if(root1 == root2){
                continue;
            }
            rootId[Math.min(root1, root2)] = Math.max(root2, root1);
            total += cost;
            treeEdgeCount++;
            if(treeEdgeCount >= n){
                break;
            }
        }
        return total;
    }

    private int getRoot(int[] rootId, int node){
        if(rootId[node] == node){
            return node;
        }
        rootId[node] = getRoot(rootId, rootId[node]);
        return rootId[node];
    }
}
