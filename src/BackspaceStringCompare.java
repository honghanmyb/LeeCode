import java.util.LinkedList;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }

    private String getString(String s){
        LinkedList<Character> list = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch != '#'){
                list.addLast(ch);
            }else{
                if(!list.isEmpty()){
                    list.pollLast();
                }
            }
        }
        StringBuilder current = new StringBuilder();
        for(char ch : list){
            current.append(ch);
        }
        return current.toString();
    }
}
