class TicTacToe {
    private int[][] board;
    private int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if(!canWinRow(row, player) && !canWinCol(col, player) && !canWinDiag(row, col, player)){
            return 0;
        }
        return player;
    }

    private boolean canWinRow(int row, int player){
        for(int i = 0; i < n; i++){
            if(board[row][i] != player){
                return false;
            }
        }
        return true;
    }

    private boolean canWinCol(int col, int player){
        for(int i = 0; i < n; i++){
            if(board[i][col] != player){
                return false;
            }
        }
        return true;
    }

    private boolean canWinDiag(int row, int col, int player){
        if(row == col){
            boolean canWin = true;
            for(int i = 0; i < n; i++){
                if(board[i][i] != player){
                    canWin = false;
                    break;
                }
            }
            if(canWin){
                return true;
            }
        }
        if(row + col == n - 1){
            boolean canWin = true;
            for(int i = 0; i < n; i++){
                if(board[i][n - i - 1] != player){
                    canWin = false;
                    break;
                }
            }
            if(canWin){
                return true;
            }
        }
        return false;
    }
}