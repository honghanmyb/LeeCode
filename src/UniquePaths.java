
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		m--; n--;
		if(m < n) {
			int temp = m;
			m = n;
			n = temp;
		}
		double result = 1;
		for(int i = 1; i <=n; i++) {
			result *= (m + n - i + 1);
			//result /= (n - i + 1);
		}
		for(int i = 1; i <= n; i++) {
			result /= (n - i + 1);
		}
		
		return (int)result;
	}
}
