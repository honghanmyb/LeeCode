import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinNumberOfTabsToWaterGarden {
    public int minTaps(int n, int[] ranges) {
        List<int[]> intervals = new ArrayList<>();
        for(int i = 0; i < ranges.length; i++){
            if(ranges[i] == 0){
                continue;
            }
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            intervals.add(new int[]{left, right});
        }
        Collections.sort(intervals, (interval1, interval2) -> {
            if(interval1[0] != interval2[0]){
                return interval1[0] - interval2[0];
            }
            return - (interval1[1] - interval1[0]) + (interval2[1] - interval2[0]);
        });
        int tapCount = 0;
        int rightMost = 0;
        int curIndex = 0;
        while(rightMost < n){
            int maxRightMost = rightMost;
            boolean findNextTap = false;
            for(int i = curIndex; i < intervals.size(); i++){
                int[] curInterval = intervals.get(i);
                if(curInterval[0] > rightMost){
                    break;
                }
                if(curInterval[1] > maxRightMost){
                    findNextTap = true;
                    curIndex = i;
                    maxRightMost = curInterval[1];
                }
            }
            if(!findNextTap){
                return -1;
            }
            rightMost = maxRightMost;
            tapCount++;
        }
        return tapCount;
    }
}
