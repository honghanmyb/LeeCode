import java.util.*;
public class HappyNumber {
	public boolean isHappy(int n) {
		int currentNumber = n;
		HashSet<Integer> set = new HashSet<>();
		while(true) {
			int temp = 0;
			while(currentNumber != 0) {
				temp += Math.pow(currentNumber % 10, 2);
				currentNumber /= 10;
			}
			if(temp == 1) return true;
			if(set.contains(temp)) break;
			set.add(temp);
			currentNumber = temp;
		}
		return false;
	}
}
