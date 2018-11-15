import java.util.*;

/*
 * a triangle looks like this:
 * 		1
 * 		12	
 * 		123
 * 		...
 * In order to find the minimum path from top to buttom, first find the paths of two consecutive rows.
 * these two rows will merge into a new row, representing the costs from the first rwo to second row.
 * In this way, merge the whole triangle into a row, and that row should be the answer.
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size() == 0) return 0;
		if(triangle.size() == 1) return triangle.get(0).get(0);
		List<Integer> down;
		List<Integer> up;
		for(int i = triangle.size() - 1; i >= 1; i--) {
			down = triangle.get(i);
			up = triangle.get(i - 1);
			for(int j = 0; j < up.size(); j++) {
				int temp = up.get(j);
				temp += Math.min(down.get(j), down.get(j+1));
				up.set(j, temp);
			}
		}
		return triangle.get(0).get(0);
    }
}
