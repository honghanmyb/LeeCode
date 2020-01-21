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
            checkHorizontally(board, crushCells);
            checkVertically(board, crushCells);
            if(crushCells.isEmpty()){
                break;
            }
            updateBoard(board, crushCells);
        }
        return board;
    }

    private void checkHorizontally(int[][] board, List<int[]> crushCells){
        for(int i = 0; i < board.length; i++){
            boolean find = false;
            for(int j = 1; j < board[0].length - 1; j++){
                if(board[i][j] == 0){
                    continue;
                }
                if(!find){
                    if(board[i][j - 1] == board[i][j] && board[i][j] == board[i][j + 1]){
                        find = true;
                        crushCells.add(new int[]{i, j - 1});
                        crushCells.add(new int[]{i, j});
                        crushCells.add(new int[]{i, j + 1});
                    }
                }else{
                    if(board[i][j] == board[i][j + 1]){
                        crushCells.add(new int[]{i, j + 1});
                    }else{
                        find = false;
                    }
                }
            }
        }
    }

    private void checkVertically(int[][] board, List<int[]> crushCells){
        for(int j = 0; j < board[0].length; j++){
            boolean find = false;
            for(int i = 1; i < board.length - 1; i++){
                if(board[i][j] == 0){
                    continue;
                }
                if(!find){
                    if(board[i - 1][j] == board[i][j] && board[i][j] == board[i + 1][j]){
                        find = true;
                        crushCells.add(new int[]{i - 1, j});
                        crushCells.add(new int[]{i, j});
                        crushCells.add(new int[]{i + 1, j});
                    }
                }else{
                    if(board[i][j] == board[i + 1][j]){
                        crushCells.add(new int[]{i + 1, j});
                    }else{
                        find = false;
                    }
                }
            }
        }
    }

    private void updateBoard(int[][] board, List<int[]> crushCells){
        for(int[] cell : crushCells){
            board[cell[0]][cell[1]] = 0;
        }
        for(int j = 0; j < board[0].length; j++){
            int emptyCount = 0;
            for(int i = board.length - 1; i >= 0; i--){
                if(board[i][j] == 0){
                    emptyCount++;
                }else{
                    board[i + emptyCount][j] = board[i][j];
                }
            }
            for(int i = 0; i < emptyCount; i++){
                board[i][j] = 0;
            }
        }
        crushCells.clear();
    }
}
