import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		int[] results = new int[]{
				494015499,494090643,494094297,494099890,494103229,494109028,494114780,494118056,494125959,494128217,494131879,494132441
		};
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i < results.length; i++){
			list.add(results[i] - results[i - 1]);
		}
		System.out.println(list);
	}
}
