import java.util.ArrayList;
import java.util.List;

public class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        //check horizontally
        //check vertically
        //update values
        //update board
        List<int[]> crushCells = new ArrayList<>();
        while(true){
            if(!shouldUpdate(board)){
                break;
            }
            updateBoard(board);
        }
        return board;
    }

    private boolean shouldUpdate(int[][] board){
        boolean update = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 1; j < board[0].length - 1; j++){
                if(board[i][j] == 0){
                    continue;
                }
                int curVal = Math.abs(board[i][j]);
                if(Math.abs(board[i][j - 1]) == curVal && Math.abs(board[i][j + 1]) == curVal){
                    update = true;
                    board[i][j - 1] = board[i][j] = board[i][j + 1] = -curVal;
                }
            }
        }

        for(int j = 0; j < board[0].length; j++){
            for(int i = 1; i < board.length - 1; i++){
                if(board[i][j] == 0){
                    continue;
                }
                int curVal = Math.abs(board[i][j]);
                if(Math.abs(board[i - 1][j]) == curVal && Math.abs(board[i + 1][j]) == curVal){
                    update = true;
                    board[i - 1][j] = board[i][j] = board[i + 1][j] = -curVal;
                }
            }
        }
        return update;
    }

    private void updateBoard(int[][] board){
        for(int j = 0; j < board[0].length; j++){
            int emptyCount = 0;
            for(int i = board.length - 1; i >= 0; i--){
                if(board[i][j] < 0){
                    emptyCount++;
                }else{
                    board[i + emptyCount][j] = board[i][j];
                }
            }
            for(int i = 0; i < emptyCount; i++){
                board[i][j] = 0;
            }
        }
    }
}
