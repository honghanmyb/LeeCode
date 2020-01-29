public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int sPos = S.length() - 1;
        int tPos = T.length() - 1;
        while (true) {
            sPos = findNextValidPos(S, sPos);
            tPos = findNextValidPos(T, tPos);
            if (sPos < 0 && tPos < 0) {
                break;
            } else if (sPos < 0 || tPos < 0) {
                return false;
            }
            if (S.charAt(sPos--) != T.charAt(tPos--)) {
                return false;
            }
        }
        return true;
    }

    private int findNextValidPos(String s, int pos) {
        int backspaceCount = 0;
        while (pos >= 0) {
            if (s.charAt(pos) == '#') {
                backspaceCount++;
                --pos;
            } else {
                if (backspaceCount == 0) {
                    return pos;
                } else {
                    --backspaceCount;
                    --pos;
                }
            }
        }
        return -1;
    }
}
