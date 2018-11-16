import java.util.*;

public class TriangleII {
	public List<Integer> getRow(int rowIndex){
		List<Integer> oldRow = new ArrayList<Integer>();
		oldRow.add(1);
		if(rowIndex == 0) {
			return oldRow;
		}
		oldRow.add(1);
		if(rowIndex == 1) {
			return oldRow;
		}
		List<Integer> newRow = new ArrayList<Integer>();
		newRow.add(1);
		for(int i = 2; i <= rowIndex; i++) {
			for(int j = 1; j < i; j++) {
				newRow.add(oldRow.get(j - 1) + oldRow.get(j));
			}
			newRow.add(1);
			oldRow = newRow;
			newRow = new ArrayList<>();
			newRow.add(1);
		}
		return oldRow;
	}
}
