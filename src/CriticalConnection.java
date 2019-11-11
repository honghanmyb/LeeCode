import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnection {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //first reconstrue the graph using matrix
    	//then use Tarjan's algorithm
    	//basically, the question is to find circles in a graph
    	//start with a random node(node 0 in this example, since all the nodes are connected, one dfs will
    	//travel through all nodes)
    	//each node, we have array level to record the lowest index it can reach, excluding the parent node
    	//and we have array timer to record the very first time we find this node
    	//then we iterate all its attach nodes, except the parent, during which time we can update the level
    	//for a attached node, if its level is smaller or equal to the node's timer, that means the attached
    	//node can somehow go back to the node, which means there's a circle
    	//but if the attached node's level is larger than the timer, it means the attached node cannot travel
    	//back to the node, so the connection between node and the attached node must be a critical connection
        List<List<Integer>> criticalConnections = new ArrayList<>();
        if(n == 1){
            return criticalConnections;
        }
        
        List<List<Integer>> graph = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(List<Integer> connection: connections){
            int head = connection.get(0);
            int tail = connection.get(1);
            graph.get(head).add(tail);
            graph.get(tail).add(head);
        }
        int[] level = new int[n];
        int[] timer = new int[n];
        boolean[] visit = new boolean[n];
        findNodeLevel(graph, 0, level, timer, 0, 1, criticalConnections);
        
        return criticalConnections;
    }
    
    private void findNodeLevel(List<List<Integer>> graph, int currentNode, int[] level, int[] timer, int parentNode, int currentLevel, List<List<Integer>> criticalConnections){
        List<Integer> connectingNodes = graph.get(currentNode);
        level[currentNode] = currentLevel;
        timer[currentNode] = currentLevel;
        for(int connectingNode: connectingNodes){
            if(connectingNode == parentNode){
                continue;
            }
            if(level[connectingNode] == 0){
                findNodeLevel(graph, connectingNode, level, timer, currentNode, currentLevel + 1, criticalConnections);
            }
            if(timer[currentNode] < level[connectingNode]){
                criticalConnections.add(Arrays.asList(currentNode, connectingNode));
            }else{
                level[currentNode] = Integer.min(level[currentNode], level[connectingNode]);
            }
        }
    }
}
