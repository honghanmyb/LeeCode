import java.util.Random;
import java.util.TreeMap;

public class RandomPickWithWeight {
    private int total = 0;
    private Random rand = new Random();
    private TreeMap<Integer, Integer> map;
    public RandomPickWithWeight(int[] w) {
        this.map = new TreeMap<>();
        for(int i = 0; i < w.length; i++){
            total += w[i];
            map.put(total, i);
        }
    }

    public int pickIndex() {
        int index = rand.nextInt(total);
        int ceilingKey = this.map.ceilingKey(index + 1);
        return this.map.get(ceilingKey);
    }
}
