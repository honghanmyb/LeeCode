import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrogPosAfterTSeconds {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        int[][] tree = new int[n + 1][n + 1];
        for (int[] edge : edges) {
            tree[edge[0]][edge[1]] = 1;
            tree[edge[1]][edge[0]] = 1;
        }
        double[] probability = new double[n + 1];
        Arrays.fill(probability, 1.0);
        int[] childCount = new int[n + 1];
        probability[1] = 1;
        addRelativeProbability(1, tree, probability, childCount, -1);
        List<Integer> routes = new ArrayList<>();
        findRoutes(1, tree, target, routes, childCount, -1);
        if (routes.size() - 1 < t && childCount[target] > 0 || routes.size() - 1 > t) {
            return 0;
        }
        double frogProbability = 1;
        for (int i = routes.size() - 1; i >= 0; i--) {
            frogProbability *= probability[routes.get(i)];
        }
        return frogProbability;
    }

    private boolean findRoutes(int node, int[][] tree, int target, List<Integer> routes, int[] childCount, int parent) {
        if (node == target) {
            routes.add(node);
            return true;
        }
        if (childCount[node] == 0) {
            return false;
        }
        boolean findRoute = false;
        for (int i = 1; i < tree.length; i++) {
            if (i == parent) continue;
            if (tree[node][i] == 1) {
                findRoute = findRoute || findRoutes(i, tree, target, routes, childCount, node);
            }
        }
        if (findRoute) {
            routes.add(node);
        }
        return findRoute;
    }

    private void addRelativeProbability(int node, int[][] tree, double[] probability, int[] childCount, int parent) {
        int children = 0;
        for (int i = 1; i < tree.length; i++) {
            if (i == parent) continue;
            if (tree[node][i] == 1) {
                ++children;
                addRelativeProbability(i, tree, probability, childCount, node);
            }
        }
        childCount[node] = children;
        if (children == 0) {
            return;
        }
        double relativePro = 1.0 / children;
        for (int i = 1; i < tree.length; i++) {
            if (i == parent) continue;
            if (tree[node][i] == 1) {
                probability[i] = relativePro;
            }
        }
    }
}
