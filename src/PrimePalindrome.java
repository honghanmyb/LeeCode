public class PrimePalindrome {
    public int primePalindrome(int N) {
        if(N <= 2){
            return 2;
        }
        if(N <= 11 && N > 7){
            return 11;
        }
        int tempN = N;
        int root = 1;
        while(tempN >= 100){
            tempN /= 100;
            root *= 10;
        }
        while(true){
            int tempRoot = root;
            while(root <= tempRoot * 10){
                int palindromeOdd = getNext(root++, true);
                if(palindromeOdd >= N && isPrime(palindromeOdd)){
                    return palindromeOdd;
                }
            }
            root = tempRoot;
            while(root <= tempRoot * 10){
                int palindromeEven = getNext(root++, false);
                if(palindromeEven >= N && isPrime(palindromeEven)){
                    return palindromeEven;
                }
            }
            root = tempRoot * 10;
        }
    }

    private boolean isPrime(int N){
        for(int i = 2; i <= (int)Math.sqrt(N); i++){
            if(N % i == 0){
                return false;
            }
        }
        return true;
    }

    private int getNext(int root, boolean isOdd){
        int curNum = root;
        int temp = isOdd ? root / 10 : root;
        while(temp > 0){
            int last = temp % 10;
            curNum = curNum * 10 + last;
            temp /= 10;
        }
        return curNum;
    }
}
