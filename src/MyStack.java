import java.util.*;
public class MyStack {
	public MyStack() {
		que = new LinkedList<>();
	}
	
	public void push(int x) {
		que.add(x);
	}
	
	public int pop() {
		Queue<Integer> temp = new LinkedList<>();
		while(true) {
			int num = que.poll();
			if(que.isEmpty()) {
				que = temp;
				return num;
			}
			temp.add(num);
			
		}
	}
	
	public int top() {
		int num = pop();
		que.add(num);
		return num;
	}
	
	public boolean empty() {
		return que.isEmpty();
	}
	Queue<Integer> que;
}
