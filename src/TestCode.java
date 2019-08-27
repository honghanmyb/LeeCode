import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		BasicCalculator test = new BasicCalculator();
		System.out.println(test.calculate("3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4"));
//		"1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10"
		System.out.println(test.calculate("1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10"));
		System.out.println(test.calculate("(1+(4+5+2)-3)+(6+8)"));

	}
}
