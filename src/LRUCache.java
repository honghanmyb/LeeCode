import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {
    private int count = 0;
    private int capacity;
    private Map<Integer, ValueAge> map;
    private PriorityQueue<ValueAge> heap;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.heap = new PriorityQueue<>(capacity, (valueAge1, valueAge2) -> {
           return valueAge1.age - valueAge2.age; 
        });
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            ValueAge value = map.get(key);
            heap.remove(value);
            value.age = count++;
            heap.add(value);
            return value.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        ValueAge oldValue = this.map.get(key);
        ValueAge newValue = new ValueAge(key, value, count++);
        this.map.put(key, newValue); 
        this.heap.add(newValue);
        if(oldValue != null){
            this.heap.remove(oldValue);
        }else if(this.heap.size() > this.capacity){
            ValueAge lruCache = heap.poll();
            this.map.remove(lruCache.key);
        }
    }
    
    private class ValueAge{
        public int age;
        public int value;
        public int key;
        
        public ValueAge(int key, int value, int age){
            this.key = key;
            this.value = value;
            this.age = age;
        }
    }
}
