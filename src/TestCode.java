import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		RepeatedDNASequence test = new RepeatedDNASequence();
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		
		System.out.println(test.findRepeatedDnaSequence(s));
	}
}
