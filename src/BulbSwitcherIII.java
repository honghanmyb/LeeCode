import java.util.HashSet;
import java.util.Set;

public class BulbSwitcherIII {
    public int numTimesAllBlue(int[] light) {
        Set<Integer> turnedLights = new HashSet<>();
        int largestTurnOn = 0;
        int momentCount = 0;
        for(int bulb : light){
            turnedLights.add(bulb);
            largestTurnOn = Math.max(largestTurnOn, bulb);
            if(turnedLights.size() == largestTurnOn){
                momentCount++;
            }
        }
        return momentCount;
    }
}
