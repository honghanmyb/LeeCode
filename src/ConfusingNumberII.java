public class ConfusingNumberII {
    public int confusingNumberII(int N) {
        int[] digits = new int[]{0, 1, 6, 8, 9};
        int count = 0;
        for(int i = 1; i < digits.length; i++){
            count += findNumber(digits[i], digits, N);
        }
        return count;
    }

    private int findNumber(int currentNum, int[] digits, int N){
        int count = isConfusingNum(currentNum) ? 1 : 0;
        for(int digit: digits){
            if((long) currentNum * 10 + digit > N){
                continue;
            }
            count += findNumber(currentNum * 10 + digit, digits, N);
        }
        return count;
    }

    private boolean isConfusingNum(int num){
        int temp = num;
        long after = 0;
        while(num > 0){
            int last = num % 10;
            num /= 10;
            after *= 10;
            if(last == 6){
                after += 9;
            }else if(last == 9){
                after += 6;
            }else{
                after += last;
            }
        }
        return temp != after;
    }
}
