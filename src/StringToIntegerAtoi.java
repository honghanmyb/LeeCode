
public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.isEmpty()){
            return 0;
        }
        char firstCh = str.charAt(0);
        if(firstCh > '9' || firstCh < '0'){
            if(firstCh != '-' && firstCh != '+'){
                return 0;
            }
        }
        int stopPos = 1;
        while(stopPos < str.length()){
            if(str.charAt(stopPos) < '0' || str.charAt(stopPos) > '9'){
                break;
            }
            stopPos++;
        }
        str = str.substring(0, stopPos);
        try{
            return Integer.parseInt(str);
        }catch(Exception e){
            if(str.equals("+") || str.equals("-")){
                return 0;
            }
            return firstCh == '-' ? Integer.MIN_VALUE: Integer.MAX_VALUE;
        }
    }
}
