
public class StudentAttendenceRecordII {
    public int checkRecord(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 3;
        }
        if(n == 2){
            return 8;
        }
        if(n == 3){
            return 19;
        }
        int treshHold = 1000000000 + 7;
        long[] noA = new long[n + 1];
        long[] withA = new long[n + 1];
        noA[1] = 2; noA[2] = 4; noA[3] = 7;
        withA[1] = 3; withA[2] = 8; withA[3] = 19;
        for(int i = 4; i < n + 1; i++){
            noA[i] = noA[i - 1] + noA[i - 2] + noA[i - 3];
            withA[i] = noA[i] + withA[i - 1] + withA[i -2] + withA[i - 3];
            withA[i] %= treshHold;
            noA[i] %= treshHold;
        }
        return (int)withA[n];
    }
}
