import java.util.*;
public class BullsCows {

	public String getHint(String secret, String guess) {
		int bull = 0;
		int cow = 0;
		this.secret = secret;
		this.guess = guess;
		//check if secret length is 0 or 1
		if(secret.length() == 0) return "";
		if(secret.length() == 1) {
			if(secret.equals(guess)) {
				return "1A0B";
			}
			return "0A0B";
		}
		bull = getBull();
//		char[] secretChar = secret.toCharArray();
		System.out.println(this.secret + " " + this.guess);
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < this.secret.length(); i++) {
			if(map.containsKey(this.secret.charAt(i))) {
				map.put(this.secret.charAt(i), map.get(this.secret.charAt(i)) + 1);
			}else {
				map.put(this.secret.charAt(i), 1);
			}

		}
		
		for(int i = 0; i < this.guess.length(); i++) {
			Integer position = map.get(this.guess.charAt(i));
			if(position == null) continue;
			if(position > 0) {
				map.put(this.guess.charAt(i), map.get(this.guess.charAt(i)) - 1);
				cow++;
			}
		}
		
		
		return String.valueOf(bull) + "A" + String.valueOf(cow) + "B";
	}
	
	private int getBull() {
		int i = 1;
		int count = 0;
		boolean firstOne = false;
		if(secret.charAt(0) == guess.charAt(0)) {
			count++;
			firstOne =true;
		}
		while(i < secret.length()) {
			if(secret.charAt(i) == guess.charAt(i)) {
				count++;
				secret = secret.substring(0, i) + secret.substring(i + 1);
				guess = guess.substring(0, i) + guess.substring(i + 1);
				i--;
			}
			i++;
		}
		
		if(firstOne) {
			secret = secret.substring(1);
			guess = guess.substring(1);
		}
//		System.out.println(secret + " " + guess);
		return count;
	}
	
	private String secret;
	private String guess;
}
