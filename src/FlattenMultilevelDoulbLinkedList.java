public class FlattenMultilevelDoulbLinkedList {
    public Node flatten(Node head) {
        Node temp = head;
        while(temp != null){
            if(temp.child != null){
                Node next = temp.next;
                Node child = flatten(temp.child);
                temp.child = null;
                temp.next = child;
                child.prev = temp;
                while(child.next != null){
                    child = child.next;
                }
                if(next != null){
                    next.prev = child;
                }
                child.next = next;
                temp = next;
                continue;
            }
            temp = temp.next;
        }
        return head;
    }

    private class Node{
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
