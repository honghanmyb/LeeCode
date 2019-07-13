import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UglyNumberII {
	public int nthUglyNumber(int n) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		if(n <= 3) return list.get(n - 1);

		int[] baseStartFactors = new int[3];
		while(list.size() < n) {
			findNextUglyNumber(list, baseStartFactors);
		}
		
		return list.get(n - 1);
	}
	
	private void findNextUglyNumber(List<Integer> list, int[] baseStartFactors) {
		int lastNum = list.get(list.size() - 1);
		int firstCandidate = getCandidate(list, lastNum, baseStartFactors, 2);
		int secondCandidate = getCandidate(list, lastNum, baseStartFactors, 3);
		int thirdCandidate = getCandidate(list, lastNum, baseStartFactors, 5);
		
		int nextNum = Math.min(firstCandidate, secondCandidate);
		nextNum = Math.min(nextNum, thirdCandidate);
		list.add(nextNum);
	}
	
	private int getCandidate(List<Integer> list, int target, int[] baseFactors, int base) {
		int baseFactorIndex = 0;
		if(base == 3) {
			baseFactorIndex = 1;
		}
		if(base == 5) {
			baseFactorIndex = 2;
		}
		int factorIndex = baseFactors[baseFactorIndex];
		int candidate = base * list.get(factorIndex);
		while(candidate <= target) {
			factorIndex++;
			candidate = base * list.get(factorIndex);
		}
		baseFactors[baseFactorIndex] = factorIndex--;
		
		return candidate;
	}
}
