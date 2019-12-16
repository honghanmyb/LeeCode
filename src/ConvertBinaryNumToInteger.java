public class ConvertBinaryNumToInteger {
    public int getDecimalValue(ListNode head) {
        int current = head.val;
        ListNode temp = head.next;
        while(temp != null){
            current *= 2;
            current += temp.val;
            temp = temp.next;
        }
        return current;
    }
}
