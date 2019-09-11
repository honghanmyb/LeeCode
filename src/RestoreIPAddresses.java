import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> resotreIpAddresses(String s){
		if(s == null || s == "") {
			return new ArrayList<>();
		}
		List<String> ipAddresses = new ArrayList<>();
		List<String> currentIpAddress = new ArrayList<>();
		addAllIpAddress(s, currentIpAddress, ipAddresses, 4);
		return ipAddresses;
	}
	
	private void addAllIpAddress(String s, List<String> currentIpAddress, 
			List<String> ipAddresses, int numOfDotLeft) {
		if(numOfDotLeft == 1) {
			if(!isValidIpPiece(s)) {
				return;
			}
			currentIpAddress.add(s);
			ipAddresses.add(String.join(".", currentIpAddress));
			currentIpAddress.remove(currentIpAddress.size() - 1);
			return;
		}
		for(int i = 0; i < s.length(); i++) {
			String currentIpAddressPiece = s.substring(0, i + 1);
			if(isValidIpPiece(currentIpAddressPiece)) {
				currentIpAddress.add(currentIpAddressPiece);
				addAllIpAddress(s.substring(i + 1), currentIpAddress, ipAddresses, numOfDotLeft - 1);
				currentIpAddress.remove(currentIpAddress.size() - 1);
			}else {
				break;
			}
		}
	}
	
	private boolean isValidIpPiece(String s) {
		if(s.length() > 1 && s.startsWith("0")) {
			return false;
		}
		if(s.equals("")) {
			return false;
		}
		if(s.length() > 3) {
			return false;
		}
		return Integer.parseInt(s) <= 255;
	}
}
