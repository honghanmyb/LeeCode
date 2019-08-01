import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointerInEachNodeII {
	public Node connect(Node root) {
		if(root == null) {
			return null;
		}
		Queue<Node> connectQueue = new LinkedList<>();
		Queue<Node> childNodeQueue = new LinkedList<>();
		
		connectQueue.add(root);
		while(true) {
			while(!connectQueue.isEmpty()) {
				Node topNode = connectQueue.poll();
				topNode.next = connectQueue.peek();
				if(topNode.left != null) {
					childNodeQueue.add(topNode.left);
				}
				if(topNode.right != null) {
					childNodeQueue.add(topNode.right);
				}
			}
			Queue<Node> temp = connectQueue;
			connectQueue = childNodeQueue;
			childNodeQueue = temp;
			if(connectQueue.isEmpty()) {
				break;
			}
		}
		return root;
	}
}
