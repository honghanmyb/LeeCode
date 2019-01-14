
public class AddBinary {
	public String addBinary(String a, String b) {
		char[] aChar = a.toCharArray();
		char[] bChar = b.toCharArray();
		
		char[] resultChar = new char[Math.max(aChar.length, bChar.length) + 1];
		
		for(int i = 1; i < resultChar.length; i++) {
			if(i <= aChar.length) {
				resultChar[resultChar.length - i] += aChar[aChar.length - i];
			}
			if(i <= bChar.length) {
				resultChar[resultChar.length - i] += bChar[bChar.length - i];
			}
			
			if(resultChar[resultChar.length - i] > '1') resultChar[resultChar.length - i] -= '0';
			
		}
		resultChar[0] = '0';
		
		for(int i = resultChar.length - 1; i > 0; i--) {
			resultChar[i - 1] += (resultChar[i] - 1) / '1';
			resultChar[i] = (char)(resultChar[i] % '0' % 2 + '0');
		}
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(resultChar);
		String result = String.copyValueOf(resultChar);
		if(result.charAt(0) == '0') {
			result = result.substring(1);
		}
//		System.out.println(result);
		return result;


	}
}
