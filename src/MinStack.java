import java.util.Collections;
import java.util.Stack;

public class MinStack {
	Stack<Integer> stack;
	ListNode dummyHead;
    public MinStack() {
    	stack = new Stack<>();
    	dummyHead = new ListNode(0);
    }
    
    public void push(int x) {
    	stack.push(x);
        insertNewNode(new ListNode(x));
    }
    
    public void pop() {
        removeNode(stack.pop());
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
    	return dummyHead.next.val;
    }
    
   private void insertNewNode(ListNode newNode) {
	   if(dummyHead.next == null) {
		   dummyHead.next = newNode;
		   return;
	   }
	   ListNode current = dummyHead.next;
	   if(current.val >= newNode.val) {
		   dummyHead.next = newNode;
		   newNode.next = current;
		   return;
	   }
	   while(current != null) {
		   if(current.next == null) {
			   current.next = newNode;
			   return;
		   }
		   if(current.next.val >= newNode.val) {
			   newNode.next = current.next;
			   current.next = newNode;
			   return;
		   }
		   current = current.next;
	   }
   }
   
   private void removeNode(int x) {
	   ListNode current = dummyHead;
	   while(current != null) {
		   if(current.next.val == x) {
			   current.next = current.next.next;
			   return;
		   }
		   current = current.next;
	   }
   }
}
