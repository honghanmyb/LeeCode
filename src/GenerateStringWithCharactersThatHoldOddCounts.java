public class GenerateStringWithCharactersThatHoldOddCounts {
    public String generateTheString(int n) {
        String oddS = n % 2 == 0 ? "a" : "b";
        for(int i = 0; i < n - 1; i++){
            oddS += "b";
        }
        return oddS;
    }
}
