
public class SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        int[] charPos = new int[26];
        for(int i = 0; i < keyboard.length(); i++){
            char ch = keyboard.charAt(i);
            charPos[ch - 'a'] = i;
        }
        int currentPos = 0;
        int totalTime = 0;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            totalTime += Math.abs(charPos[ch - 'a'] - currentPos);
            currentPos = charPos[ch - 'a'];
        }
        return totalTime;
    }
}
