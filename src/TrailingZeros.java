
public class TrailingZeros {
	public int trailingZeros(int n) {
		int count = 0;
		long fact = 1;
		for(int i = 1; i <= n; i++) {
			fact *= i;
			if(fact % 10 == 0) {
				fact /= 10;
				count ++;
			}
			fact %= 1000000000;
		}
		return count;
	}
}
