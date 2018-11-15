import java.math.*;

public class TitleToNumber {
	public int titletoNumber(String s) {
		int result = 0;
		for(int i = 0 ; i < s.length(); i++) {
			result += Math.pow(26, s.length() - 1 - i) * (s.charAt(i) - 'A' +1);
		}
		
		return result;
	}
}
