import java.util.LinkedList;
import java.util.Queue;

public class ReadNCharacterGivenRead4II {
    private boolean reachEnd = false;
    private Queue<Character> queue = new LinkedList<>();
    public int read(char[] buf, int n) {
        while(!this.reachEnd){
            char[] buf4 = new char[4];
            read4(buf4);
            for(int i = 0; i < 4; i++){
                if(buf4[i] == 0){
                    this.reachEnd = true;
                    break;
                }
                queue.add(buf4[i]);
            }
        }
        if(queue.size() == 0){
            return 0;
        }
        int current = 0;
        int times = Math.min(queue.size(), n);
        for(int i = 0; i < times; i++){
            buf[current++] = queue.poll();
        }
        return current;
    }

    private int read4(char[] buf4){
        return 0;
    }
}
