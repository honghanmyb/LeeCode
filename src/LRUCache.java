import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class LRUCache {
    private int capacity;
    private HashMap<Integer, LRUCacheElement> map;
    private LRUCacheElement head;
    private LRUCacheElement tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new LRUCacheElement(0, 0);
        this.tail = new LRUCacheElement(0, 0);
        head.next = tail;
        tail.previous = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            LRUCacheElement node = map.get(key);
            moveToTail(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            LRUCacheElement node = map.get(key);
            node.value = value;
            moveToTail(node);
        }else{
            LRUCacheElement newNode = new LRUCacheElement(key, value);
            moveToTail(newNode);
            map.put(key, newNode);
            if(map.size() > this.capacity){
                int removedNodeKey = removeFirstNode();
                map.remove(removedNodeKey);
            }
        }
    }
    
    private void moveToTail(LRUCacheElement node){
        LRUCacheElement previous = node.previous;
        LRUCacheElement next = node.next;
        if(previous != null && next != null){
            previous.next = next;
            next.previous = previous;
        }
        LRUCacheElement nodeBeforeTail = this.tail.previous;
        nodeBeforeTail.next = node;
        node.previous = nodeBeforeTail;
        node.next = tail;
        tail.previous = node;
    }
    
    private int removeFirstNode(){
        LRUCacheElement nodeToRemove = head.next;
        head.next = nodeToRemove.next;
        nodeToRemove.next.previous = head;
        return nodeToRemove.key;
    }
    
    private class LRUCacheElement {
        public int key;
        public int value;
        public LRUCacheElement previous;
        public LRUCacheElement next;
        
        public LRUCacheElement(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
