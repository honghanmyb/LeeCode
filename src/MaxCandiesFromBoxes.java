import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaxCandiesFromBoxes {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int candyCount = 0;
        Queue<Integer> openBoxes = new LinkedList<>();
        Set<Integer> closedBoxes = new HashSet<>();
        Set<Integer> unusedKeys = new HashSet<>();
        for(int box : initialBoxes){
            if(status[box] == 1){
                openBoxes.add(box);
            }else{
                closedBoxes.add(box);
            }
        }
        openBoxes.add(-1);
        while(true){
            int curBox = openBoxes.poll();
            if(curBox == -1){
                Set<Integer> tempKeys = new HashSet<>();
                for(int key : unusedKeys){
                    if(closedBoxes.contains(key)){
                        openBoxes.add(key);
                        closedBoxes.remove(key);
                    }else{
                        tempKeys.add(key);
                    }
                }
                unusedKeys = tempKeys;
                if(openBoxes.isEmpty()){
                    break;
                }else{
                    openBoxes.add(-1);
                }
                continue;
            }
            candyCount += candies[curBox];
            for(int box : containedBoxes[curBox]){
                if(status[box] == 1){
                    openBoxes.add(box);
                }else{
                    closedBoxes.add(box);
                }
            }
            for(int key : keys[curBox]){
                if(closedBoxes.contains(key)){
                    openBoxes.add(key);
                    closedBoxes.remove(key);
                }else{
                    unusedKeys.add(key);
                }
            }
        }
        return candyCount;
    }
}
