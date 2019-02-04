import java.util.*;
public class PopulateNextPointer {
	public void connect(TreeLinkNode root) {
		if(root == null) return;
		Queue<TreeLinkNode> linkQueue = new LinkedList<>();
		Queue<TreeLinkNode> addQueue = new LinkedList<>();
		linkQueue.add(root);
		while(!linkQueue.isEmpty()) {
			int count = linkQueue.size();
			for(int i = 0; i < count; i++) {
				TreeLinkNode top = linkQueue.remove();
				top.next = linkQueue.peek();
				if(top.left != null) {
					addQueue.add(top.left);
					addQueue.add(top.right);
				}
			}
			while(!addQueue.isEmpty()) {
				linkQueue.add(addQueue.remove());
			}
			
		}
		
	}
}
