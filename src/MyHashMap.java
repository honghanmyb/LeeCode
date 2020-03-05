import java.util.ArrayList;
import java.util.List;

class MyHashMap {
    private List<Node>[] map;
    private int modInt;
    /** Initialize your data structure here. */
    public MyHashMap() {
        modInt = 30001;
        this.map = new ArrayList[modInt];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int pos = key % modInt;
        List<Node> nodes = map[pos] == null ? new ArrayList<>() : map[pos];
        map[pos] = nodes;
        boolean findKey = false;
        for(Node node : nodes){
            if(node.key == key){
                node.value = value;
                findKey = true;
                break;
            }
        }
        if(!findKey){
            nodes.add(new Node(key, value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(map[key % modInt] == null){
            return -1;
        }
        List<Node> nodes = map[key % modInt];
        for(Node node : nodes){
            if(node.key == key){
                return node.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        List<Node> nodes = map[key % modInt];
        if(nodes == null) return;
        for(Node node : nodes){
            if(node.key == key){
                nodes.remove(node);
                return;
            }
        }
    }

    private class Node{
        int key;
        int value;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */