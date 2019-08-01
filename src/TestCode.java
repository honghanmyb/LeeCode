import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		HIndex test = new HIndex();
		int[] citations = new int[] {0,0,0,0,0};
		System.out.print(test.hIndex(citations));
	}
}
