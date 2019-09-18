import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval){
		if(intervals.length == 0) {
			return new int[][] {newInterval};
		}
		List<int[]> intervalList = new ArrayList<>();
		int[] judgingInterval = newInterval;
		boolean hasInsert = false;
		if(newInterval[0] < intervals[0][0]) {
			
		}
		for(int i = 0; i < intervals.length; i++) {
			if(hasInsert) {
				intervalList.add(intervals[i]);
				continue;
			}
			if(intervals[i][1] < newInterval[0]) {
				intervalList.add(intervals[i]);
                continue;
			}
			if(intervals[i][0] > newInterval[1]) {
				intervalList.add(newInterval);
				intervalList.add(intervals[i]);
				hasInsert = true;
			}else{
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
		}
		if(!hasInsert) {
			intervalList.add(newInterval);
		}
		return intervalList.toArray(new int[intervalList.size()][]);
	}
}
