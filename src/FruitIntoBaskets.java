import java.util.ArrayList;
import java.util.List;

public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        boolean[] endPoint = new boolean[tree.length];
        endPoint[tree.length - 1] = true;
        List<int[]> table = new ArrayList<>();
        int currentCount = 0;
        for(int i = 0; i < tree.length; i++){
            if( i < tree.length - 1 && tree[i] != tree[i + 1]){
                endPoint[i] = true;
            }
            currentCount++;
            if(!endPoint[i]){
                continue;
            }
            table.add(new int[]{tree[i], currentCount});
            currentCount = 0;
        }
        if(table.size() <= 2){
            return tree.length;
        }
        int[] first = table.get(0);
        int firstTypePos = 0;
        int[] second = table.get(1);
        int secondTypePos = 1;
        int nextPos = 0;
        int max = 0, current = 0;
        current += first[1];
        current += second[1];
        while(true){
            nextPos = Integer.max(firstTypePos, secondTypePos) + 1;
            if(nextPos >= table.size()){
                max = Integer.max(max, current);
                break;
            }
            int[] next = table.get(nextPos);
            if(next[0] == first[0]){
                current += next[1];
                firstTypePos = nextPos;
            }else if(next[0] == second[0]){
                current += next[1];
                secondTypePos = nextPos;
            }else{
                max = Integer.max(max, current);
                firstTypePos = nextPos - 1;
                first = table.get(firstTypePos);
                secondTypePos = nextPos;
                second = table.get(secondTypePos);
                current = first[1] + second[1];
            }
        }
        return max;
    }
}
