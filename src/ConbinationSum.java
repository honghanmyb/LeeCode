import java.util.*;

public class ConbinationSum {
	public List<List<Integer>> combinationSum3(int k, int n){
		for(int i = 1; i <= 9 - k + 1; i++) {

			findAllConbination(i, 0, k, n, null);
		}
		return result;
	}
	
	private void findAllConbination(int currentNum, int count, int k, int n, ArrayList<Integer> last) {
		ArrayList<Integer> current = new ArrayList<Integer>();
		if(last != null) {
			for(int i = 0; i < last.size(); i++) current.add(last.get(i));
		}
		current.add(currentNum);
		if(current.size() == k) {
			if(currentNum == n) result.add(current);
			return;
		}
		for(int i = currentNum + 1; i < 10; i++) {

			findAllConbination(i, count + 1, k, n - currentNum, current);

		}
	}
	
	private ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
}
