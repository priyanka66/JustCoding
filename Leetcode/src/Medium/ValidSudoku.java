package Medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    private boolean isValidSudoku(char[][] board) {
        int[] row = new int[9], col = new int[9], squares = new int[9];
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                char c = board[i][j];
                if (c != '.') {
                    int val = 2 << (int) (c -'1');
                    if ((checkIfValid(row, i, val)) && checkIfValid(col, j, val) && checkIfValid(squares, (3*(i/3) + (j/3)), val)) {

                    } else {
                        return false;
                    }


                }
            }
        }

        return true;
    }

    private boolean checkIfValid(int[] check, int index, int val) {
        if ((check[index] & val) >0) return false;
        check[index] |= val;
        return true;
    }


    public static void main(String[] args) {
        ValidSudoku v = new ValidSudoku();
        char [][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(v.isValidSudoku(board));
    }
}
