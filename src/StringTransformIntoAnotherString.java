
public class StringTransformIntoAnotherString {
	/**
	 * every char in str1 must map into another char in str2, 
	 * so if there's the same char in str1 that maps two char in str2, return fasle
	 * if one of the 26 char in str2 no being used, then we can always transform str1 to str2
	 * for example, abcde -> bcdeb
	 * notice taht a maps to b, e maps to b, and there's no a in str2,
	 * so first transform e to a, then d to e, c to d, b to c, finally a to b
	 * the only case this won't work is that all of 26 chars is used in str2
	 */
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)){
            return true;
        }
        int[] table = new int[27];
        for(int i = 0; i < str1.length(); i++){
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if(table[ch1 - 'a' + 1] == 0){
                table[ch1 - 'a' + 1] = ch2 - 'a' + 1;
            }else{
                if(table[ch1 - 'a' + 1] != ch2 - 'a' + 1){
                    return false;
                }
            }
        }
        int[] valueTable = new int[27];
        for(int i = 1; i < table.length; i++){
            valueTable[table[i]] = 1;
        }
        for(int i = 1; i < valueTable.length; i++){
            if(valueTable[i] == 0){
                return true;
            }
        }
        return false;
    }
}
