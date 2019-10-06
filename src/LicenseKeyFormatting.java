
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        S = S.replaceAll("-", "");
        if(S.isEmpty()){
            return "";
        }
        int numPartsK = S.length() / K;
        int numPartLessK = S.length() % K;
        String[] sElements;
        int startIndex = 0;
        if(numPartLessK == 0){
            sElements = new String[numPartsK];
            sElements[0] = S.substring(0, K);
            startIndex = K;
        }else{
            sElements = new String[numPartsK + 1];
            sElements[0] = S.substring(0, numPartLessK);
            startIndex = numPartLessK;
        }
        for(int i = 0; i < sElements.length - 1; i++){
            sElements[i + 1] = S.substring(startIndex + i * K, startIndex + (i + 1) * K);
        }
        return String.join("-", sElements);
    }
}
