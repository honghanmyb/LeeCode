import java.util.*;
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> lastRow = null;
		for(int i = 0; i < numRows; i++) {
			List<Integer> currentRow = new ArrayList<>();
			
			if(i == 0) {
				currentRow.add(1);
				result.add(currentRow);
				lastRow = currentRow;
			}else if(i == 1) {
				currentRow.add(1);
				currentRow.add(1);
				result.add(currentRow);
				lastRow = currentRow;
			}else {
				currentRow.add(1);
				for(int j = 0; j < i - 1; j++) {
					currentRow.add(lastRow.get(j) + lastRow.get(j + 1));
				}
				currentRow.add(1);
				result.add(currentRow);
				lastRow = currentRow;
			}
		}
		return result;
	}
}
