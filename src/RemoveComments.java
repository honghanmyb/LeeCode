import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    private boolean inBlockComment = false;
    private String blockCommentCode = "";
    public List<String> removeComments(String[] source) {
        List<String> sourceWithoutComments = new ArrayList<>();
        for(String line : source){
            if(line.isEmpty()){
                continue;
            }
            if(!inBlockComment){
                String newLine = removeCommentsInLine(line);
                if(blockCommentCode.isEmpty() && !newLine.isEmpty()){
                    sourceWithoutComments.add(newLine);
                }
            }else{
                int blockEndIndex = blockCommentEndIndex(0, line);
                if(blockEndIndex != -1){
                    inBlockComment = false;
                    String newLine = blockCommentCode + line.substring(blockEndIndex + 1);
                    blockCommentCode = "";
                    newLine = removeCommentsInLine(newLine);
                    if(blockCommentCode.isEmpty() && !newLine.isEmpty()){
                        sourceWithoutComments.add(newLine);
                    }
                }
            }
        }
        return sourceWithoutComments;
    }

    private String removeCommentsInLine(String newLine){
        while(true){
            int blockStartIndex = blockCommentStartIndex(0, newLine);
            int lineCommentIndex = lineCommentIndex(0, newLine);
            if(blockStartIndex == -1 && lineCommentIndex == -1){
                break;
            }
            if(blockStartIndex != -1){
                int blockEndIndex = blockCommentEndIndex(blockStartIndex + 2, newLine);
                if(blockEndIndex == -1){
                    blockCommentCode = newLine.substring(0, blockStartIndex);
                    inBlockComment = true;
                    return "";
                }
                newLine = newLine.substring(0, blockStartIndex) + newLine.substring(blockEndIndex + 1);
            }else{
                newLine = newLine.substring(0, lineCommentIndex);
            }
        }
        return newLine;
    }

    private int lineCommentIndex(int startIndex, String line){
        for(int i = startIndex; i < line.length() - 1; i++){
            if(line.charAt(i) == '/' && line.charAt(i + 1) == '/'){
                return i;
            }
            if(line.charAt(i) == '/' && line.charAt(i + 1) == '*'){
                return -1;
            }
        }
        return -1;
    }

    private int blockCommentStartIndex(int startIndex, String line){
        for(int i = startIndex; i < line.length() - 1; i++){
            if(line.charAt(i) == '/' && line.charAt(i + 1) == '/'){
                return -1;
            }
            if(line.charAt(i) == '/' && line.charAt(i + 1) == '*'){
                return i;
            }
        }
        return -1;
    }

    private int blockCommentEndIndex(int startIndex, String line){
        for(int i = startIndex; i < line.length() - 1; i++){
            if(line.charAt(i) == '*' && line.charAt(i + 1) == '/'){
                return i + 1;
            }
        }
        return -1;
    }
}
