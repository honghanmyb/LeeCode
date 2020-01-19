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
        char[] digits = new char[n];
        int startIndex = n / 2;
        if(n % 2 == 0){
            findAllNums(startIndex - 1, startIndex, digits);
        }else {
            digits[startIndex] = '0';
            findAllNums(startIndex - 1, startIndex + 1, digits);
            digits[startIndex] = '1';
            findAllNums(startIndex - 1, startIndex + 1, digits);
            digits[startIndex] = '8';
            findAllNums(startIndex - 1, startIndex + 1, digits);
        }
        return nums;
    }

    private void findAllNums(int headIndex, int tailIndex, char[] digits){
        if(headIndex < 0){
            nums.add(new String(digits));
            return;
        }
        for(int i = 1; i < possibleChars.length; i++){
            digits[headIndex] = possibleChars[i];
            digits[tailIndex] = map.get(possibleChars[i]);
            findAllNums(headIndex - 1, tailIndex + 1, digits);
        }
        if(headIndex > 0){
            digits[headIndex] = '0';
            digits[tailIndex] = '0';
            findAllNums(headIndex - 1, tailIndex + 1, digits);
        }
    }
}
