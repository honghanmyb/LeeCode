import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> digits = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            addDigits(digits, i, i, low, high);
        }
        Collections.sort(digits);
        return digits;
    }

    private void addDigits(List<Integer> digits, int current, int lastDigit, int low, int high){
        if(current >= low && current <= high){
            digits.add(current);
        }
        if(current > high){
            return;
        }
        if(lastDigit < 9){
            addDigits(digits, current * 10 + lastDigit + 1, lastDigit + 1, low, high);
        }
    }
}
