import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldNodeToNewNode = new HashMap<>();
        Node current = head;
        Node previous = new Node();
        while(current != null){
            Node newNode = new Node();
            newNode.val = current.val;
            previous.next = newNode;
            oldNodeToNewNode.put(current, newNode);
            current = current.next;
            previous = newNode;
        }
        current = head;
        while(current != null){
            Node newCurrent = oldNodeToNewNode.get(current);
            Node randomNode = current.random == null? null: oldNodeToNewNode.get(current.random);
            newCurrent.random = randomNode;
            current = current.next;
        }
        return oldNodeToNewNode.get(head);
    }
    
    private class Node{
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
