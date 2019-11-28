import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    private Map<String, TreeMap<Integer, String>> timeMap;
    public TimeMap() {
        this.timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(this.timeMap.containsKey(key)) {
            TreeMap<Integer, String> treeMap = this.timeMap.get(key);
            treeMap.put(timestamp, value);
        }else{
            TreeMap<Integer, String> treeMap = new TreeMap<>();
            treeMap.put(timestamp, value);
            this.timeMap.put(key, treeMap);
        }
    }

    public String get(String key, int timestamp) {
        if(this.timeMap.containsKey(key)){
            TreeMap<Integer, String> treeMap = this.timeMap.get(key);
            Integer floorKey = treeMap.floorKey(timestamp);
            return floorKey == null? "": treeMap.get(floorKey);
        }
        return "";
    }
}
