import java.util.*;
public class TestCode {
	public static void main(String[] args) {
        String test = "1212321312!!??";
        String test2 = test.replaceAll("!|\\?|'|,|;|\\.", "");
        System.out.println(test2);
	}
}
