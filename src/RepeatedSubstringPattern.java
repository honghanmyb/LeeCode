public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        char firstCh = s.charAt(0);
        int sLength = s.length();
        if(sLength == 1){
            return false;
        }
        for(int i = s.length() / 2; i > 0; i--){//i is the pattern's length here
            if(s.length() % i == 0 && s.charAt(i) == firstCh){
                if(canRepeated(s, s.substring(0, i))){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canRepeated(String s, String pattern){
        int head = 0;
        int tail = pattern.length() - 1;
        while(tail < s.length()){
            if(s.substring(head, tail + 1).equals(pattern)){
                head += pattern.length();
                tail += pattern.length();
            }else{
                return false;
            }
        }
        return true;
    }
}
