public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        int thousand = 1000;
        int million = thousand * thousand;
        int billion = million * thousand;
        int[] thousands = new int[]{
                billion, million, thousand, 1
        };
        String[] thousandWords = new String[]{
                "Billion ", "Million ", "Thousand ", ""
        };
        String[] oneDigits = new String[]{
                "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten "
        };
        String[] tens = new String[]{
                "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "
        };
        String[] twoDigits = new String[]{
                "dummy", "dummy", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "
        };

        String curWord = "";
        for(int i = 0; i < thousands.length; i++){
            int translateInt = num / thousands[i];
            num %= thousands[i];
            curWord += translate(translateInt, thousandWords[i], oneDigits, tens, twoDigits);
        }
        return curWord.trim();
    }

    private String translate(int translateInt, String endWord, String[] oneDigits, String[] tens, String[] twoDigits){
        if(translateInt == 0){
            return "";
        }
        String curWord = "";
        if(translateInt >= 100){
            curWord += oneDigits[translateInt / 100];
            curWord += "Hundred ";
            translateInt %= 100;
        }
        if(translateInt >= 20){
            curWord += twoDigits[translateInt / 10];
            curWord += oneDigits[translateInt % 10];
        }else if(translateInt >= 10){
            curWord += tens[translateInt - 10];
        }else {
            curWord += oneDigits[translateInt];
        }
        return curWord + endWord;
    }
}
