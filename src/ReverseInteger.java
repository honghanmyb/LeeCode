
public class ReverseInteger {
    public int reverse(int x) {
        if(x == -2147483648){
            return 0;
        }
        int newInt = 0;
        boolean isNegetive = x < 0;
        x = isNegetive? -1 * x: x;
        int[] record = new int[10];
        while(x != 0){
            int last = x % 10;
            newInt = newInt * 10 + last;
            record[last]++;
            x /= 10;
            if(newInt < 0){
                return 0;
            }
        }
        int testInt = newInt;
        while(testInt != 0){
            int last = testInt % 10;
            record[last]--;
            if(record[last] < 0){
                return 0;
            }
            testInt /= 10;
        }
        newInt = isNegetive? -1 * newInt: newInt;
        return newInt;
    }
}
