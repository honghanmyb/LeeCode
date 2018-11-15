/*
 * return num % 9;
 */
public class AddDigit {
	public int addDigit(int num) {
		while(num >= 10) {
			int temp = num % 10;
			num /= 10;
			num += temp;
		}
		return num;
	}
}
