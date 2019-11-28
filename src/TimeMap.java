import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    private Map<String, Element> timeMap;
    public TimeMap() {
        this.timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(this.timeMap.containsKey(key)) {
            Element element = this.timeMap.get(key);
            element.set(timestamp, value);
        }else{
            Element element = new Element();
            element.set(timestamp, value);
            this.timeMap.put(key, element);
        }
    }

    public String get(String key, int timestamp) {
        if(this.timeMap.containsKey(key)){
            return this.timeMap.get(key).get(timestamp);
        }
        return "";
    }

    private class Element{
        public int largestTimestamp = 0;
        public TreeMap<Integer, String> map;

        public Element(){
            this.map = new TreeMap<>();
        }

        public void set(int timestamp, String value){
            this.map.put(timestamp, value);
            this.largestTimestamp = timestamp > this.largestTimestamp? timestamp: this.largestTimestamp;
        }

        public String get(int timestamp){
            if(timestamp > this.largestTimestamp){
                return this.map.get(this.largestTimestamp);
            }
            Integer floorKey = this.map.floorKey(timestamp);
            return floorKey == null? "": this.map.get(floorKey);
        }
    }
}
