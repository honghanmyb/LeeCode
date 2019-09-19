
public class MultiplyStrings {
	public String mutiply(String num1, String num2) {
		if(num1.isEmpty() || num2.isEmpty()) {
			return "";
		}
		if(num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int[] num1Array = new int[num1.length()];
		int[] num2Array = new int[num2.length()];
		for(int i = 0; i < num1.length(); i++) {
			num1Array[i] = num1.charAt(i) - '0';
		}
		for(int i = 0; i < num2.length(); i++) {
			num2Array[i] = num2.charAt(i) - '0';
		}
		
		int[] product = new int[num1.length() + num2.length()];
		for(int i = num2Array.length - 1; i >= 0; i--) {
			int factor = num2Array[i];
			int offPos = num2Array.length - 1 - i;
			for(int j = num1Array.length - 1; j >= 0; j--) {
				product[product.length - 1 - offPos - num1Array.length + 1 + j] += num1Array[j] * factor;
			}
		}
		int previous = 0;
		for(int i = product.length - 1; i >= 0; i--) {
			product[i] += previous;
			previous = product[i] / 10;
			product[i] %= 10;
		}
		String productString = "";
		int firstNotZeroPos = 0;
		for(int i = 0; i < product.length; i++) {
			if(product[i] == 0) {
				continue;
			}
			firstNotZeroPos = i;
			break;
		}
		for(int i = firstNotZeroPos; i < product.length; i++) {
			productString += product[i];
		}
		return productString;
	}
}
