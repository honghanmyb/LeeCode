
public class UglyNumber {
	public boolean isUgly(int num) {
		if(num <= 0) return false;
		int temp = num;
		while(temp % 2 == 0) {
			temp = temp / 2;
		}
		
		while(temp % 3 == 0) {
			temp = temp / 3;
		}
		
		while(temp % 5 == 0) {
			temp = temp / 5;
		}
		
		if(temp == 1) return true;
		return false;
	}
}
