import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LFUCache {
    private Map<Integer, Node> map;
    private int capacity;
    private int lastCall;
    private Node head;
    private Node tail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.lastCall = 0;
        this.head = new Node(0, 0, 0);
        this.tail = new Node(0, 0, 0);
        head.frequency = -1;
        tail.frequency = Integer.MAX_VALUE;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        if(this.capacity <= 0){
            return -1;
        }
        Node node = map.get(key);
        node.frequency++;
        node.lastCall = this.lastCall;
        this.lastCall++;
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(this.capacity <= 0){
            return;
        }
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            node.frequency++;
            node.lastCall = this.lastCall;
            this.lastCall++;
            update(node);
            return;
        }
        if(map.size() < capacity){
            Node node = new Node(key, value, this.lastCall);
            this.lastCall++;
            map.put(key, node);
            node.prev = head;
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
            update(node);
            return;
        }
        Node leastNode = head.next;
        map.remove(leastNode.key);
        head.next = leastNode.next;
        leastNode.next.prev = head;
        Node newNode = new Node(key, value, this.lastCall);
        this.lastCall++;
        map.put(key, newNode);
        newNode.next = head.next;
        newNode.prev = head;
        head.next = newNode;
        newNode.next.prev = newNode;
        update(newNode);
    }

    private void update(Node node){
        while(true){
            if(node.frequency < node.next.frequency){
                return;
            }
            if(node.frequency == node.next.frequency && node.lastCall < node.next.lastCall){
                return;
            }
            Node swapNode = node.next;
            Node nodeBefore = node.prev;
            Node nodeNext = swapNode.next;
            nodeBefore.next = swapNode;
            swapNode.prev = nodeBefore;
            node.next = nodeNext;
            node.prev = swapNode;
            swapNode.next = node;
            nodeNext.prev = node;
        }
    }

    private class Node{
        int key;
        int value;
        int frequency;
        int lastCall;
        Node prev;
        Node next;

        Node(int key, int value, int lastCall){
            this.key = key;
            this.value = value;
            this.frequency = 1;
            this.lastCall = lastCall;
        }
    }
}
