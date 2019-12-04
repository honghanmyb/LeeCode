import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {
    public String encode(List<String> strs) {
        if(strs.size() == 0){
            return "#";
        }
        int currentLength = strs.get(0).length();
        String header = "0," + currentLength;
        for(int i = 1; i < strs.size(); i++){
            currentLength += strs.get(i).length();
            header += "," + currentLength;
        }
        header += "#";
        String body = "";
        for(String s : strs){
            body += s;
        }
        return header + body;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
        if(s.equals("#")){
            return strs;
        }
        int index = s.indexOf("#");
        String header = s.substring(0, index);
        String body = s.substring(index + 1);
        String[] lengths = header.split(",");
        int[] lengthsInt = new int[lengths.length];
        for(int i = 0; i < lengths.length; i++){
            lengthsInt[i] = Integer.parseInt(lengths[i]);
        }
        for(int i = 0; i < lengthsInt.length - 1; i++){
            strs.add(body.substring(lengthsInt[i], lengthsInt[i + 1]));
        }
        return strs;
    }
}
