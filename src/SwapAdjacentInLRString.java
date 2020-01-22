public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        int needXtoR = 0;
        int needLtoX = 0;
        for(int i = 0; i < start.length(); i++){
            char sCh = start.charAt(i);
            char eCh = end.charAt(i);
            if(needXtoR == 0 && needLtoX == 0){
                if(sCh == eCh){
                    continue;
                }
                if(sCh == 'R'){
                    if(eCh == 'L'){
                        return false;
                    }
                    needXtoR++;
                    continue;
                }
                if(sCh == 'L'){
                    return false;
                }
                if(sCh == 'X'){
                    if(eCh == 'R'){
                        return false;
                    }
                    needLtoX++;
                    continue;
                }
            }
            if(needXtoR > 0){
                if(sCh == 'R' && eCh == 'R'){
                    continue;
                }
                if(sCh == 'X' && eCh == 'X'){
                    continue;
                }
                if(sCh == 'X' && eCh == 'R'){
                    needXtoR--;
                    continue;
                }
                if(sCh == 'R' && eCh == 'X'){
                    needXtoR++;
                    continue;
                }
                return false;
            }
            if(needLtoX > 0){
                if(sCh == 'L' && eCh == 'L'){
                    continue;
                }
                if(sCh == 'X' && eCh == 'X'){
                    continue;
                }
                if(sCh == 'L' && eCh == 'X'){
                    needLtoX--;
                    continue;
                }
                if(sCh == 'X' && eCh == 'L'){
                    needLtoX++;
                    continue;
                }
                return false;
            }
        }
        return needXtoR == 0 && needLtoX == 0;
    }
}
