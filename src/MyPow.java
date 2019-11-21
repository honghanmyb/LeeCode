
public class MyPow {
    public double myPow(double x, int n) {
        double result = 1;
        if(n == 0){
            return result;
        }
        if(n == 1){
            return x;
        }
        boolean isNegetive = n < 0;
        n = isNegetive ? -n: n;
        int rest = 0;
        if(n < 0){
            n = Integer.MAX_VALUE;
            rest = 1;
        }
        double half = myPow(x, n / 2);
        if(n % 2 == 0){
            result = half * half;
        }else {
            result = half * half * x;
        }
        if(rest != 0){
            result *= x;
        }
        if(isNegetive){
            result = 1 / result;
        }
        return result;
    }
}
