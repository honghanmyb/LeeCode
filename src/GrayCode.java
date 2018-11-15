import java.util.*;
public class GrayCode {
	public List<Integer> grayCode(int n){
		List<Integer> result = new ArrayList<>();
		result.add(0);
		result.add(1);
		if(n == 1) return result;
		for(int i = 2; i <=n; i++) {
			for(int j = result.size() - 1; j >=0 ; j--) {
				result.add((int)(result.get(j) + Math.pow(2, i - 1)));
			}
		}
		return result;
	}
}
