
public class ExcelSheetColumnTitle {
	public String convert(int n) {
        n -= 1;
        if(n == 0){
            return "A";
        }
        char[] table = new char[26];
        table[0] = 'A';
        for(int i = 0; i < table.length; i++){
            table[i] = (char)('A' + i);
        }
        String title = "";
        while(n >= 0){
            int currentIndex = n % 26;
            n /= 26;
            n -= 1;
            title = table[currentIndex] + title;
        }
        return title;
	}
}
