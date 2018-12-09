
public class TrailingZeros {
	public int trailingZeros(int n) {
		int maxIndex = 0;
		while(true) {
			if(Math.pow(5, maxIndex) > n) break;
			maxIndex++;
		}
		int count = 0;
		if(maxIndex == 1) return 0;
		for(int i = 1; i < maxIndex; i++) {
			count += n/Math.pow(5, i);
		}
		return count;
	}
}
