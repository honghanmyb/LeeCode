import java.util.TreeSet;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        TreeSet<Integer> set = new TreeSet<>();
        int max = -1;
        for(int num : A){
            Integer maxNum = set.lower(K - num);
            if(maxNum != null){
                max = Math.max(max, num + maxNum);
            }
            set.add(num);
        }
        return max;
    }
}
