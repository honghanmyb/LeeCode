
public class PlusOne {
	public int[] plusOne(int[] digits) {
		
		if(digits == null) return digits;
		if(digits[digits.length - 1] != 9) {
			digits[digits.length - 1] += 1;
			return digits;
		}
		
		int firstNotNine = -1;
		for(int i = digits.length - 1; i >= 0; i--) {
			if(digits[i] != 9) {
				firstNotNine = i;
				break;
			}
		}
		
		if(firstNotNine < 0) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = 1;
			return newDigits;
		}
		
		digits[firstNotNine] += 1;
		for(int i = firstNotNine + 1; i < digits.length; i++) {
			digits[i] = 0;
		}
		
		return digits;
	}
}
