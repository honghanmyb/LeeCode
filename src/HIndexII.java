import java.util.ArrayList;
import java.util.List;

public class HIndexII {
	public int hIndex(int[] citations) {
        if(citations.length == 0) {
            return 0;
        }
        int possibleHIndex = 0;
		int N = citations.length;
		for(int i = 1; i <= N; i++) {
			if(citations[N - i] >= i) {
				if(N == i || citations[N - i - 1] <= i) {
					possibleHIndex = i;
				}
			}
		}
		return possibleHIndex;
	}
}
