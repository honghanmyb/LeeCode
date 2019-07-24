import java.util.ArrayList;
import java.util.List;

public class HIndexII {
	public int hIndex(int[] citations) {
        int possibleHIndex = 0;
		int N = citations.length;
        if(N == 0) {
            return 0;
        }
        if(citations[0] >= N) {
        	return N;
        }
		for(int i = 1; i < N; i++) {
			if(citations[N - i] >= i && citations[N - i - 1] <= i) {
				possibleHIndex = i;
			}
		}
		
		return possibleHIndex;
	}
}
