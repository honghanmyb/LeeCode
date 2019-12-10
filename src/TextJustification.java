import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int curWidth = 0;
        int head = 0;
        int tail = 0;
        int curWidthNotSpace = 0;
        List<String> sList = new ArrayList<>();
        while(tail < words.length){
            curWidth += words[tail].length();
            curWidthNotSpace += words[tail].length();
            if(curWidth < maxWidth){
                curWidth++;
                tail++;
            }else if(curWidth == maxWidth){
                addString(words, head, tail, maxWidth, curWidthNotSpace, sList, tail == words.length - 1);
                head = tail + 1;
                tail = head;
                curWidth = 0;
                curWidthNotSpace = 0;
            }else{
                addString(words, head, tail - 1, maxWidth, curWidthNotSpace - words[tail].length(), sList, false);
                head = tail;
                curWidth = 0;
                curWidthNotSpace = 0;
            }
        }
        if(head < words.length){
            addString(words, head, tail - 1, maxWidth, curWidthNotSpace, sList, true);
        }
        return sList;
    }

    private void addString(String[] words, int head, int tail, int maxWidth, int wordWidthNotSpace, List<String> sList, boolean isLeftJustified){
        if(isLeftJustified || head == tail){
            String s = "" + words[head];
            for(int i = head + 1; i <= tail; i++){
                s += " " + words[i];
            }
            int extraSpaceCount = maxWidth - s.length();
            while(extraSpaceCount > 0){
                s += " ";
                extraSpaceCount--;
            }
            sList.add(s);
            return;
        }
        int evenSpace = (maxWidth - wordWidthNotSpace) / (tail - head);
        int remainSpace = (maxWidth - wordWidthNotSpace) % (tail - head);
        String s = "" + words[head];
        for(int i = head + 1; i <= tail; i++){
            for(int j = 0; j < evenSpace; j++){
                s += " ";
            }
            if(remainSpace > 0){
                s += " ";
                remainSpace--;
            }
            s += words[i];
        }
        sList.add(s);
    }
}
