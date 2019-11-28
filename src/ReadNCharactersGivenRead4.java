public class ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        int current = 0;
        boolean reachEnd = false;
        while(n >= 4){
            char[] buf4 = new char[4];
            read4(buf4);
            for(int i = 0; i < 4; i++){
                if(buf4[i] == 0){
                    reachEnd = true;
                    break;
                }
                buf[current++] = buf4[i];
            }
            if(reachEnd){
                return current;
            }
            n -= 4;
        }
        if(n > 0){
            char[] buf4 = new char[4];
            read4(buf4);
            for(int i = 0; i < n; i++){
                if(buf4[i] == 0){
                    break;
                }
                buf[current++] = buf4[i];
            }
        }
        return current;
    }
    
    private int read4(char[] buf4){
        return 0;
    }
}
