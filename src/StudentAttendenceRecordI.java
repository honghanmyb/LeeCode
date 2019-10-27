
public class StudentAttendenceRecordI {
    public boolean checkRecord(String s) {
        int countA = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'A'){
                countA ++;
                if(countA > 1){
                    return false;
                }
            }
        }
        if(s.contains("LLL")){
            return false;
        }
        return true;
    }
}
