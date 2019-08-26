import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		List<String> remainingDigit = new ArrayList<>(n);
		for(int i = 0; i < n; i++){
			remainingDigit.add(Integer.toString(i + 1));
		}
		
		int[] delimeters = new int[] {0, 1, 2, 6, 24, 120, 720, 5040, 40320};
		String result = "";
		k -= 1;
		while(n > 1) {
			int pos = k / delimeters[n - 1];
			result += remainingDigit.get(pos);
			remainingDigit.remove(pos);
			k = k % delimeters[n - 1];
			n--;
		}
		result += remainingDigit.get(0);
		return result;
	}
}
