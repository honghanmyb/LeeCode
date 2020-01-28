import java.util.HashMap;
import java.util.Map;

class MajorityChecker {
    private int[] arr;
    private Map<Integer, int[]> map;
    public MajorityChecker(int[] arr) {
        this.arr = arr;
        this.map = new HashMap<>();
    }

    public int query(int left, int right, int threshold) {
        int curRange = left * 100000 + right;
        if(map.containsKey(curRange)){
            int[] value = map.get(curRange);
            return value[1] >= threshold ? value[0] : -1;
        }
        int curVal = arr[left];
        int count = 0;
        for(int i = left; i <= right; i++){
            if(count == 0){
                curVal = arr[i];
                count++;
                continue;
            }
            if(arr[i] == curVal){
                count++;
            }else{
                count--;
            }
        }
        count = 0;
        for(int i = left; i <= right; i++){
            if(arr[i] == curVal){
                count++;
            }
        }
        int[] newValue = new int[]{curVal, count};
        map.put(curRange, newValue);
        if(count >= threshold){
            return curVal;
        }
        return -1;
    }
}