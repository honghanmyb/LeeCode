
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if(numRows <= 1) {
			return s;
		}
		int subStringLength = 2 * numRows - 2;
		int emptyStringNum = subStringLength - s.length() % subStringLength;
		char[][] sCharElements = new char[s.length() / subStringLength + 1][2 * numRows - 2];
		for(int i = 0; i < sCharElements.length - 1; i++) {
			sCharElements[i] = s.substring(i * subStringLength, (i + 1) * subStringLength).toCharArray();
		}
		char[] lastCharArray = sCharElements[sCharElements.length - 1];
		String lastString = s.substring(subStringLength * (sCharElements.length - 1));
		for(int i = 0; i < lastString.length(); i++) {
			lastCharArray[i] = lastString.charAt(i);
		}
		String result = "";
		for(int i = 0; i < sCharElements.length; i++) {
			if(sCharElements[i][0] != '\0') {
				result += sCharElements[i][0];
			}
		}
		for(int i = 1; i < numRows - 1; i++) {
			for(int j = 0; j < sCharElements.length; j++) {
				if(sCharElements[j][i] != '\0') {
					result += sCharElements[j][i];
				}
				if(sCharElements[j][subStringLength - i] != '\0') {
					result += sCharElements[j][subStringLength - i];
				}
			}
		}
		for(int i = 0; i < sCharElements.length; i++) {
			if(sCharElements[i][numRows - 1] != '\0') {
				result += sCharElements[i][numRows - 1];
			}		
		}
		return result;
	}
}
