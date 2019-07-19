
public class BitwiseAndRangeNumbers {
	public int rangeBitwiseAnd(int m, int n) {
		if(m == n) return m;
		if(m * n == 0) return 0;
		int result = 0;
		while(true) {
			int mZeros = Integer.numberOfLeadingZeros(m);
			int nZeros = Integer.numberOfLeadingZeros(n);
			
			if(nZeros != mZeros) {
				return result;
			}
			int deduction = (int)Math.pow(2.0, 32 - mZeros - 1);
			result += deduction;
			m -= deduction;
			n -= deduction;
		}
	}
}
