import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums){
		List<String> ranges = new ArrayList<>();
		if(nums.length == 0) {
			return ranges;
		}
		int rangeStartNum = nums[0], rangeCurrentNum = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] - rangeCurrentNum == 1) {
				rangeCurrentNum = nums[i];
				continue;
			}
			
			addNewRange(ranges, rangeStartNum, rangeCurrentNum);
			rangeCurrentNum = rangeStartNum = nums[i];
		}
		
		addNewRange(ranges, rangeStartNum ,rangeCurrentNum);
		return ranges;
	}
	
	private void addNewRange(List<String> ranges, int rangeStartNum, int rangeCurrentNum) {
		if(rangeCurrentNum == rangeStartNum) {
			ranges.add(Integer.toString(rangeStartNum));
			return;
		}
		
//		ranges.add(String.format("%s->%s", Integer.toString(rangeStartNum),
//					Integer.toString(rangeCurrentNum)));
		ranges.add(rangeStartNum + "->" + rangeCurrentNum);
	}
}
