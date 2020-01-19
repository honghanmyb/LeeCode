import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumberIII {
    private int count = 0;
    private char[] possibleDigits;
    private Map<Character, Character> map;
    public int strobogrammaticInRange(String low, String high) {
        if(!isLargerOrEqual(high, low)){
            return 0;
        }
        possibleDigits = new char[]{'0', '1', '6', '8', '9'};
        if(high.length() == 1){
            char[] possibleNum = new char[]{'0', '1', '8'};
            int count = 0;
            for(char num : possibleNum){
                if(withinRange(low, high, "" + num)){
                    count++;
                }
            }
            return count;
        }
        map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        findAllNums(high.length() / 2, "", low, high);
        findAllNums(high.length() / 2, "1", low, high);
        findAllNums(high.length() / 2, "0", low, high);
        findAllNums(high.length() / 2, "8", low, high);
        this.count += low.equals("0") ? 1 : 0;
        return this.count;
    }

    private void findAllNums(int remainDigits, String curString, String low, String high){
        if(remainDigits < 0){
            return;
        }
        if(!curString.isEmpty() && curString.charAt(0) != '0'){
            if(withinRange(low, high, curString)){
                ++count;
            }
        }
        for(char digit : possibleDigits){
            findAllNums(remainDigits - 1, digit + curString + map.get(digit), low, high);
        }
    }

    private boolean withinRange(String low, String high, String num){
        return isLargerOrEqual(num, low) && isLargerOrEqual(high, num);
    }

    private boolean isLargerOrEqual(String high, String low){
        if(low.length() > high.length()){
            return false;
        }
        if(low.length() < high.length()){
            return true;
        }
        for(int i = 0; i < high.length(); i++){
            char lowCh = low.charAt(i);
            char highCh = high.charAt(i);
            if(highCh > lowCh){
                return true;
            }
            if(highCh < lowCh){
                return false;
            }
        }
        return true;
    }
}
