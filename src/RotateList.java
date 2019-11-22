
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        k %= count;
        if(k == 0){
            return head;
        }
        temp = dummy;
        for(int i = 0; i < count - k; i++){
            temp = temp.next;
        }
        ListNode endTemp = temp;
        while(endTemp.next != null){
            endTemp = endTemp.next;
        }
        ListNode next = temp.next;
        temp.next = null;
        endTemp.next = head;
        dummy.next = next;
        return dummy.next;
    }
}
