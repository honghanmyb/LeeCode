import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceKinBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, List<Integer>> nodeToConnectingNodes = new HashMap<>();
        nodeToConnectingNodes.put(root.val, new ArrayList<>(3));
        putAllNodes(root, nodeToConnectingNodes);
        List<Integer> nodesDistK = new ArrayList<>();
        findAllNodes(target.val, nodeToConnectingNodes, K, nodesDistK, -1);
        return nodesDistK;
    }

    private void findAllNodes(int curNodeVal, Map<Integer, List<Integer>> nodeToConnectingNodes, int K, List<Integer> nodesDistK, int prevNodeVal) {
        if (K == 0) {
            nodesDistK.add(curNodeVal);
            return;
        }
        List<Integer> connectingNodes = nodeToConnectingNodes.get(curNodeVal);
        for (int connectingNode : connectingNodes) {
            if (connectingNode == prevNodeVal) continue;
            findAllNodes(connectingNode, nodeToConnectingNodes, K - 1, nodesDistK, curNodeVal);
        }
    }

    private void putAllNodes(TreeNode node, Map<Integer, List<Integer>> nodeToConnectingNodes) {
        List<Integer> connectingNodes = nodeToConnectingNodes.get(node.val);
        if (node.left != null) {
            List<Integer> leftList = new ArrayList<>(3);
            connectingNodes.add(node.left.val);
            leftList.add(node.val);
            nodeToConnectingNodes.put(node.left.val, leftList);
            putAllNodes(node.left, nodeToConnectingNodes);
        }
        if (node.right != null) {
            List<Integer> rightList = new ArrayList<>(3);
            connectingNodes.add(node.right.val);
            rightList.add(node.val);
            nodeToConnectingNodes.put(node.right.val, rightList);
            putAllNodes(node.right, nodeToConnectingNodes);
        }
    }
}
