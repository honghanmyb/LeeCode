
public class IntegerToRoman {
	public String intToRoman(int num) {
		String s = "";
		int[] marks = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] results = {"M", "CM", "D", "CD", "C", "XC", "L","XL", "X", "IX", "V", "IV", "I"};
		for(int i = 0; i < marks.length; i++) {
			switch(i) {
			case 0: case 4: case 8: case 12:{
				if(num >= marks[i]) {
					int count = num / marks[i];
					for(int j = 0; j < count; j++) {
						s += results[i];
					}
					num %= marks[i];
				}
				break;
			}
			default: {
				if(num >= marks[i]) {
					s += results[i];
					num %= marks[i];
				}
				break;
			}
			}
		}
		return s;
		/*while(num != 0) {
			if(num >= 1000) {
				int count = num / 1000;
				for(int i = 0; i < count; i++) s += "M";
				num %= 1000;
			}
			if(num >= 900) {
				s += "CM";
				num %= 900;
			}
			if(num >= 500) {
				s += "D";
				num %= 500;
			}
			if(num >= 400) {
				s += "CD";
				num %= 400;
			}
			if(num >= 100) {
				int count = num / 100;
				for(int i = 0; i < count; i++) s +="C";
				num %= 100;
			}
			if(num >= 90) {
				s += "XC";
				num %= 90;
			}
			if(num >= 50) {
				s += "L";
				num %= 50;
			}
			if(num >= 40) {
				s += "XL";
				num %= 40;
			}
			if(num >= 10) {
				int count = num / 10;
				for(int i = 0; i < count; i++) s +="X";
				num %= 10;
			}
			if(num >= 9) {
				s += "IX";
				num %= 9;
			}
			if(num >= 5) {
				s += "V";
				num %= 5;
			}
			if(num >= 4) {
				s += "IV";
				num %= 4;
			}
			if(num >= 1) {
				int count = num ;
				for(int i = 0; i < count; i++) s +="I";
				num %= 1;
			}
			
		}
		return s;*/
	}
}
