import java.util.*;
public class PerfectSequ {
	public int numSquares(int n) {
		int[] hops = new int[n+1];
		int[] squares = new int[n + 1];
		int i = 1;
		int square = 1;
		while(square <= n) {
			hops[square] = 1;
			squares[i] = square;
			i++;
			square = i * i;
		}
		
		
		return findMinHop(n, hops, squares);
		
	}
	
	private int findMinHop(int target, int[] hops, int[] squares) {
		if(hops[target] != 0) return hops[target]; 
		int minHop = Integer.MAX_VALUE;
		for(int i = 1; i <= target; i++) {
			if(squares[i] > target) break;
			int currentHop = 1 + findMinHop(target - squares[i], hops, squares);
			if(minHop > currentHop) minHop = currentHop;
		}
		hops[target] = minHop;
		return minHop;
	}
	
}
