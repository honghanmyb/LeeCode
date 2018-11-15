import java.util.*;
public class NumOfOnes {
	public int hummingWeight(double n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		ArrayList<Double> twoPowers = new ArrayList<>();
		double mark = 1;
		while(mark <= n) {
			twoPowers.add(mark);
			mark *= 2;
			
		}
		
		return findHummingWeight(n, twoPowers, twoPowers.size() - 1);
		
	}
	
	private int findHummingWeight(double n, List<Double> twoPowers, int largestIndex) {
		if(n == twoPowers.get(largestIndex)) return 1;
		if(n == 0) return 0;
		while(twoPowers.get(largestIndex) > n) {
			largestIndex -= 1;
		}
		return 1 + findHummingWeight(n - twoPowers.get(largestIndex), twoPowers, largestIndex - 1);
	}
}
