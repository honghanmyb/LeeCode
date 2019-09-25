
public class LongestPalindromicSubstring {
    private int maxHead = 0;
    private int maxTail = 0;
    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return "";
        }
        for(int i = 0; i < s.length(); i++){
            findMaxPalindrome(s, i, i);
            findMaxPalindrome(s, i, i + 1);
        }
        return s.substring(maxHead, maxTail + 1);
    }
    
    private void findMaxPalindrome(String s, int head, int tail){
        while(true){
            if(head < 0 || tail >= s.length() || s.charAt(head) != s.charAt(tail)){
                if(tail - 2 - head > maxTail - maxHead){
                    maxHead = head + 1;
                    maxTail = tail - 1; 
                }
                return;
            }
            head -= 1;
            tail += 1;
        }
    }
}
