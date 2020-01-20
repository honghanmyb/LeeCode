public class ReorganizeString {
    public String reorganizeString(String S) {
        int[] charCount = new int[26];
        for(int i = 0; i < S.length(); i++){
            charCount[S.charAt(i) - 'a']++;
        }
        int maxCount = 0;
        int totalCount = 0;
        for(int i = 0; i < charCount.length; i++){
            if(charCount[i] > maxCount){
                maxCount = charCount[i];
            }
            totalCount += charCount[i];
        }
        if(totalCount - maxCount >= maxCount - 1){
            char[] charArr = new char[S.length()];
            int curPos = 0;
            char prevChar = '0';
            while(curPos < charArr.length){
                charArr[curPos++] = getNext(charCount, prevChar);
                prevChar = charArr[curPos - 1];
            }
            return new String(charArr);
        }
        return "";
    }

    private char getNext(int[] charCount, char prevChar){
        char maxChar = 'a';
        int maxCount = 0;
        for(int i = 0; i < charCount.length; i++){
            if(prevChar - 'a' != i && charCount[i] > maxCount){
                maxCount = charCount[i];
                maxChar = (char)('a' + i);
            }
        }
        charCount[maxChar - 'a']--;
        return maxChar;
    }
}
