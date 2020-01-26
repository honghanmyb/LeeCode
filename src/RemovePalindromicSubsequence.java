public class RemovePalindromicSubsequence {
    public int removePalindromeSub(String s) {
        if(s.isEmpty()){
            return 0;
        }
        if(isPalindrome(s)){
            return 1;
        }else{
            return 2;
        }
    }

    private boolean isPalindrome(String s){
        char[] sArr = s.toCharArray();
        int head = 0;
        int tail = sArr.length - 1;
        while(head <= tail){
            if(sArr[head++] != sArr[tail--]){
                return false;
            }
        }
        return true;
    }
}
