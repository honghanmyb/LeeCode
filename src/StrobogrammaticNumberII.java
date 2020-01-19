import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII {
    private Map<Character, Character> map;
    private char[] possibleChars;
    private List<String> nums;
    public List<String> findStrobogrammatic(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        if(n == 1){
            return Arrays.asList("0", "1", "8");
        }
        map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        possibleChars = new char[]{'0', '1', '6', '8', '9'};
        nums = new ArrayList<>();
        if(n % 2 == 0){
            findAllNums(n / 2, "");
        }else {
            findAllNums(n / 2, "0");
            findAllNums(n / 2, "1");
            findAllNums(n / 2, "8");
        }
        return nums;
    }

    private void findAllNums(int remainCount, String curString){
        if(remainCount == 0){
            nums.add(curString);
            return;
        }
        for(int i = 1; i < possibleChars.length; i++){
            findAllNums(remainCount - 1, possibleChars[i] + curString + map.get(possibleChars[i]));
        }
        if(remainCount > 1){
            findAllNums(remainCount - 1, possibleChars[0] + curString + map.get(possibleChars[0]));
        }
    }
}
