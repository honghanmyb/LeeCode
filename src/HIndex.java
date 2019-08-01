import java.util.Arrays;

public class HIndex {
	public int hIndex(int[] citations) {
		if(citations.length == 0) {
			return 0;
		}
		Arrays.sort(citations);
		if(citations[0] >= citations.length) {
			return citations.length;
		}
		int maxHIndex = 0;
		for(int i = 1; i < citations.length; i++) {
			if(citations[citations.length - i] >= i && citations[citations.length - i - 1] <= i ) {
				maxHIndex = Math.max(i, maxHIndex);
			}
		}
		return maxHIndex;
	}
}
