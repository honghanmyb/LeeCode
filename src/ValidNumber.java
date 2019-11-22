
public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.isEmpty()){
            return false;
        }
        char firstCh = s.charAt(0);
        if(firstCh < '0' || firstCh > '9'){
            if(firstCh != '+' && firstCh != '-' && firstCh != '.'){
                return false;
            }
            if(s.length() == 1){
                return false;
            }
        }
        boolean findDot = false, findE = false;
        if(firstCh == '.'){
            findDot = true;
        }
        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                if(ch == 'e' && !findE){
                    if(i == s.length() - 1){
                        return false;
                    }
                    if(s.charAt(i - 1) < '0' || s.charAt(i - 1) > '9'){
                        if(s.charAt(i - 1) == '.'){
                            if(i == 1){
                                return false;
                            }
                            continue;
                        }
                        return false;
                    }
                    findE = true;
                    continue;
                }
                return false;
            }
            if(ch == '.'){
                if(findDot || findE){
                    return false;
                }
                if(s.charAt(i - 1) < '0' || s.charAt(i - 1) > '9'){
                    if(s.charAt(i - 1) != '+' && s.charAt(i - 1) != '-'){
                        return false;   
                    }else if(i == s.length() - 1){
                        return false;
                    }
                }
                findDot = true;
                continue;
            }
            if(ch == '+' || ch == '-'){
                if(s.charAt(i - 1) != 'e'){
                    return false;
                }
                if(i == s.length() - 1){
                    return false;
                }
                continue;
            }
            if(ch < '0' || ch > '9'){
                return false;
            }
        }
        return true;
    }
}
