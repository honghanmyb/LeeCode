import java.util.TreeMap;
import java.util.TreeSet;

public class OddEvenJump {
    public int oddEvenJumps(int[] A) {
        boolean[] canReachOdd = new boolean[A.length];
        boolean[] canReachEven = new boolean[A.length];
        canReachOdd[A.length - 1] = true;
        canReachEven[A.length - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[A.length - 1], A.length - 1);
        for(int i = A.length - 2; i >= 0; i--){
            Integer small = map.ceilingKey(A[i]);
            Integer large = map.floorKey(A[i]);
            if(small != null){
                canReachOdd[i] = canReachEven[map.get(small)];
            }
            if(large != null){
                canReachEven[i] = canReachOdd[map.get(large)];
            }
            map.put(A[i], i);
        }
        int count = 0;
        for(int i = 0; i < A.length; i++){
            if(canReachOdd[i]){
                count++;
            }
        }
        return count;
    }
}
