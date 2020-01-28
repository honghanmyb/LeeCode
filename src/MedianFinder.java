import java.util.PriorityQueue;

public class MedianFinder {
	private PriorityQueue<Integer> firstHalf;
	private PriorityQueue<Integer> secondHalf;
	/** initialize your data structure here. */
	public MedianFinder() {
		firstHalf = new PriorityQueue<>(1, (int1, int2) -> int2 - int1);
		secondHalf = new PriorityQueue<>(1, (int1, int2) -> int1 - int2);
	}

	public void addNum(int num) {
		firstHalf.add(num);
		secondHalf.add(firstHalf.poll());
		if(firstHalf.size() < secondHalf.size()){
			firstHalf.add(secondHalf.poll());
		}
	}

	public double findMedian() {
		if(!firstHalf.isEmpty() && !secondHalf.isEmpty()){
			if(firstHalf.size() == secondHalf.size()){
				return 0.5 * firstHalf.peek() + 0.5 * secondHalf.peek();
			}
		}
		return firstHalf.peek() * 1.0;
	}
}
