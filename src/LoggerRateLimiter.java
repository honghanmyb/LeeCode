import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    /** Initialize your data structure here. */
    Map<String, Integer> msgToTime;
    public LoggerRateLimiter() {
        msgToTime = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(msgToTime.containsKey(message)){
            int lastTime = msgToTime.get(message);
            if(timestamp - lastTime < 10){
                return false;
            }
            msgToTime.put(message, timestamp);
        }else{
            msgToTime.put(message, timestamp);
        }
        return true;
    }
}
