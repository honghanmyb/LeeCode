
public class RomanToInt {
	public int romanToInt(String s) {
		int result = 0;
		int i = 0;
		while(s.length() > 1) {
			switch(s.charAt(i++)) {
			case 'I':{
				if(s.charAt(i) == 'V') {
					result += 4;
					i += 1;
					break;
				}else if(s.charAt(i) == 'X'){
					result += 9;
					i += 1;
					break;
				}else{
					result ++; break;
				}

			}
			case 'V' :{
				result += 5; break;
			}
			case 'X':{
				if(s.charAt(i) == 'L') {
					result += 40;
					i += 1;
					break;
				}else if(s.charAt(i) == 'C'){
					result += 90;
					i += 1;
					break;
				}else{
					result += 10; break;
				}

			}
			case 'L' :{
				result += 50; break;
			}
			case 'C':{
				if(s.charAt(i) == 'D') {
					result += 400;
					i += 1;
					break;
				}else if(s.charAt(i) == 'M'){
					result += 900;
					i += 1;
					break;
				}else{
					result += 100; break;
				}

			}
			case 'D' :{
				result += 500; break;
			}
			case 'M' :{
				result += 1000; break;
			}
			}
			if(i >= s.length() - 1) break;
		}
		
		if(i == s.length() - 1) {
			switch (s.charAt(i)) {
			case'I':  return result +=1;
			case'V':  return result +=5;
			case'X':  return result +=10;
			case'L':  return result += 50;
			case'C': return result += 100;
			case 'D': return result += 500;
			case 'M': return result += 1000;
			}
		}
		return result;
	}
}
