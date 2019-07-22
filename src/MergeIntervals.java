import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MergeIntervals {
	public int[][] merge(int[][] intervals){
		if(intervals.length == 0) return intervals;
		Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
		Set<int[]> mergedSet = new HashSet<>();//think of another approache than set
		int[] lastArray = intervals[0];
		mergedSet.add(lastArray);
		for(int i = 1; i < intervals.length; i++) {
			int[] currentArray = intervals[i];
			if(currentArray[0] <= lastArray[1]) {
				mergedSet.remove(lastArray);
				int[] newArray = {Math.min(lastArray[0], currentArray[0]),
						Math.max(lastArray[1], currentArray[1])};
				mergedSet.add(newArray);
				lastArray = newArray;
				continue;
			}
			
			mergedSet.add(currentArray);
			lastArray = currentArray;
		}
		
		Iterator setIterator = mergedSet.iterator();
		int[][] result = new int[mergedSet.size()][];
		for(int i = 0; i < result.length; i++) {
			result[i] = (int[]) setIterator.next();
		}
		
		return result;
	}
}
