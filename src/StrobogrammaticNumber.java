import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> chars = new HashMap<>();
        chars.put('0', '0');
        chars.put('1', '1');
        chars.put('6', '9');
        chars.put('8', '8');
        chars.put('9', '6');

        int head = 0;
        int tail = num.length() - 1;
        while(head <= tail){
            char chHead = num.charAt(head);
            char chTail = num.charAt(tail);
            if(!chars.containsKey(chHead)){
                return false;
            }
            if(chars.get(chHead) != chTail){
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}
