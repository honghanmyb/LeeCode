import java.util.*;
public class NQueensII {
	
	public List<List<String>> solveQueens(int n){
		List<List<String>> result = new ArrayList<>();
		
		List<String> record = new ArrayList<>();
		findAllValid(result, record, n);
		return result;
	}
	
	
	private void findAllValid(List<List<String>> result, List<String> record, int n) {
		for(int i = 0; i < n; i++) {
			String row = createString(i, n);
			if(isValid(row, record)) {
				record.add(row);
				if(record.size() == n) {
					List<String> copy = new ArrayList<>();
					copy.addAll(record);
					result.add(copy);
					record.remove(row);
					continue;
				}
				findAllValid(result, record, n);
				
				record.remove(row);
			}
		}
		
	}
	
	private boolean isValid(String row, List<String> record) {
		if(record.size() == 0) return true;
		for(int i = 0; i < record.size(); i++) {
			if(record.get(i).indexOf('Q') == row.indexOf('Q')) {
				return false;
				
			}
			if(Math.abs(record.size() - i) == Math.abs(row.indexOf('Q') - record.get(i).indexOf('Q'))) {
				return false;
			}
		}
		
		return true;
	}
	
	//need a more efficient way to construct string.
	private String createString(int queenPos, int n) {
		String result = "";
		for(int i = 0; i < queenPos; i++) {
			result += ".";
		}
		result += "Q";
		for(int i = queenPos + 1; i < n; i++) {
			result += ".";
		}
		
		return result;
	}
}
