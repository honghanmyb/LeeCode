import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words){
        List<String> boardWords = new ArrayList<>();
        int[][] boardRecord = new int[board.length][board[0].length];
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            boolean findThisWord = false;
            for(int j = 0; j < board.length; j++){
                if(findThisWord){
                    break;
                }
                for(int k = 0; k < board[0].length; k++){
                    if(board[j][k] == word.charAt(0)){
                        boardRecord[j][k] = i + 1;
                        if(!findWord(word, board, j, k, 1, boardWords, boardRecord, i + 1)){
                            boardRecord[j][k] = 0;
                        }else{
                            findThisWord = true;
                            break;
                        }
                    }
                }
            }
        }
        return boardWords;
	}
	
    private boolean findWord(String word, char[][] board, int x, int y, int charPos, 
            List<String> boardWords, int[][] boardRecord, int flagNum){
    	if(charPos >= word.length()){
    		boardWords.add(word);
    		return true;
    	}
    	char currentChar = word.charAt(charPos);
    	if(x > 0){
    		if(boardRecord[x - 1][y] != flagNum && board[x - 1][y] == currentChar){
    			boardRecord[x - 1][y] = flagNum;
    			if(findWord(word, board, x - 1, y, charPos + 1, boardWords, boardRecord, flagNum)){
    				return true;
    			}
    			boardRecord[x - 1][y] = 0;
    		}
    	}
    	if(x < board.length - 1){
    		if(boardRecord[x + 1][y] != flagNum && board[x + 1][y] == currentChar){
    			boardRecord[x + 1][y] = flagNum;
    			if(findWord(word, board, x + 1, y, charPos + 1, boardWords, boardRecord, flagNum)){
    				return true;
    			}
    			boardRecord[x + 1][y] = 0;
    		}
    	}
    	if(y > 0){
    		if(boardRecord[x][y - 1] != flagNum && board[x][y - 1] == currentChar){
    			boardRecord[x][y - 1] = flagNum;
    			if(findWord(word, board, x, y - 1, charPos + 1, boardWords, boardRecord, flagNum)){
    				return true;
    			}
    			boardRecord[x][y - 1] = 0;
    		}
    	}
    	if(y < board[0].length - 1){
    		if(boardRecord[x][y + 1] != flagNum && board[x][y + 1] == currentChar){
    			boardRecord[x][y + 1] = flagNum;
    			if(findWord(word, board, x, y + 1, charPos + 1, boardWords, boardRecord, flagNum)){
    				return true;
    			}
    			boardRecord[x][y + 1] = 0;
    		}
    	}

    	return false;
    }
}
	
