public class Max69Number {
    public int maximum69Number (int num) {
        int newNum = 0;
        int divisor = 10000;
        boolean hasFoundFirstSix = false;
        while(num > 0){
            int curDigit = num / divisor;
            num %= divisor;
            divisor /= 10;
            if(!hasFoundFirstSix && curDigit == 6){
                newNum = newNum * 10 + 9;
                hasFoundFirstSix = true;
            }else{
                newNum = newNum * 10 + curDigit;
            }
        }
        return newNum;
    }
}
