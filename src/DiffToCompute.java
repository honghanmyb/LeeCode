import java.util.*;
public class DiffToCompute {
	public List<Integer> differentWaysToCompute(String input){
		ArrayList<Integer> result = new ArrayList<Integer>();
		int symbolCount = countSymbol(input);
		if(symbolCount == 0) {
			result.add(Integer.valueOf(input));
			return result;
		}else if(symbolCount == 1) {
			int temp = 0;
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) < '0' || input.charAt(i) >'9') {
					temp = i;
					break;
				}
			}
			String left = input.substring(0, temp);
			String right = input.substring(temp + 1);
			char symbol = input.charAt(temp);
			if(symbol == '+') result.add(Integer.valueOf(left) + Integer.valueOf(right));
			else if(symbol == '-') result.add(Integer.valueOf(left) - Integer.valueOf(right));
			else result.add(Integer.valueOf(left) * Integer.valueOf(right));
			return result;
		}
		for(int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			if(temp == '+' || temp == '-' || temp == '*') {
				List<Integer> left = differentWaysToCompute(input.substring(0, i));
				List<Integer> right = differentWaysToCompute(input.substring(i + 1, input.length()));
				for(int j = 0; j < left.size(); j++) {
					for(int k = 0; k < right.size(); k++) {
						if(temp == '+') result.add(left.get(j) + right.get(k));
						else if(temp == '-') result.add(left.get(j) - right.get(k));
						else result.add(left.get(j) * right.get(k));
					}
				}
			}
		}
		
		return result;
	}
	
	private int countSymbol(String input) {
		int count = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) < '0' || input.charAt(i) > '9') count++;
			if(count > 1) break;
		}
		
		return count;
	}
}
