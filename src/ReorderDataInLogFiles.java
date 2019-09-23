import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for(String dataLog: logs){
            String[] logSplit = dataLog.split(" ", 2);
            char firstCh = logSplit[1].charAt(0);
            if('0' <= firstCh && '9' >= firstCh){
                digitLogs.add(dataLog);
            }else{
                letterLogs.add(dataLog);
            }
        }
        Collections.sort(letterLogs, (log1, log2) -> {
            String logBody1 = log1.substring(log1.indexOf(' '));
            String logBody2 = log2.substring(log2.indexOf(' '));
           if(logBody1.equals(logBody2)){
               return log1.compareTo(log2);
           }
            return logBody1.compareTo(logBody2);
        });
        for(int i = 0; i < letterLogs.size(); i++){
            logs[i] = letterLogs.get(i).toString();
        }
        for(int i = letterLogs.size(); i < logs.length; i++){
            logs[i] = digitLogs.get(i - letterLogs.size()).toString();
        }
        return logs;
    }
}
