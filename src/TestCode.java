import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		MedianFinder finder = new MedianFinder();
		finder.addNum(0);
		System.out.println(finder.findMedian());
		
		finder.addNum(3);
		System.out.println(finder.findMedian());
		
		finder.addNum(1);
		System.out.println(finder.findMedian());
	}

}
