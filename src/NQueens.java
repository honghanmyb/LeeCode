import java.util.*;
public class NQueens {
	public int totalNQueens(int n) {
		for(int i = 0; i < n; i++) {
			findAllNQueens(i, 0, n, null);
		}
		return result.size();
	}
	
	private void findAllNQueens(int currentNum, int currentCount, int n, List<Integer> last) {
		ArrayList<Integer> current = new ArrayList<Integer>();
		if(last != null) {
			for(int i = 0; i < last.size(); i++) {
				current.add(last.get(i));
			}
		}
		if(isValid(currentNum, currentCount, n, current)) {
			current.add(currentNum);
			if(currentCount + 1 == n) {
				result.add(current);
				return;
			}
			for(int i = 0; i < n; i++) findAllNQueens(i, currentCount + 1, n, current);
		}
	}
	
	private boolean isValid(int currentNum, int currentCount, int n, List<Integer> current) {
		if(current.contains(currentNum)) return false;
		for(int i = 0; i < currentCount; i++) {
			int temp = current.get(i);
			if(currentCount - i == currentNum - temp) return false;
			if(currentCount - i == temp - currentNum) return false;
		}
		return true;
	}
	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
}
