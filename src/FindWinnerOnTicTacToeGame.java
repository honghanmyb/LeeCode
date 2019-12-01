public class FindWinnerOnTicTacToeGame {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];
        int current = 1;
        for (int i = 0; i < moves.length; i++) {
            board[moves[i][0]][moves[i][1]] = current;
            current = -1 * current;
            int result = hasWinner(board);
            if (result == 1) {
                return "A";
            } else if (result == -1) {
                return "B";
            }
        }
        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";
    }

    private int hasWinner(int[][] board) {
        for (int i = 0; i < 3; i++) {
            int current = board[i][0];
            if (current == 0) {
                continue;
            }
            boolean same = true;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != current) {
                    same = false;
                }
            }
            if (same) {
                return current;
            }
        }
        for (int i = 0; i < 3; i++) {
            int current = board[0][i];
            if (current == 0) {
                continue;
            }
            boolean same = true;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] != current) {
                    same = false;
                }
            }
            if (same) {
                return current;
            }
        }
        int dia = board[0][0];
        if (dia != 0 && dia == board[1][1] && dia == board[2][2]) {
            return dia;
        }
        dia = board[0][2];
        if (dia != 0 && dia == board[1][1] && dia == board[2][0]) {
            return dia;
        }
        return 0;
    }
}
