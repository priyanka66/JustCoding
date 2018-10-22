package Medium;

import java.util.Arrays;

public class SurroundedRegions {

    private void solve(char[][] board){
        if (board.length < 2) return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        //first row and last row O's cant be flipped
        for (int i=0;i<board[0].length;i++) {
            if (board[0][i] == 'O') dfs(board, 0,i);
            if (board[board.length-1][i] == 'O') dfs(board, board.length-1,i);
        }

        //first and last column O's can't be flipped
        for (int j=0;j<board.length;j++) {
            if (board[j][0] == 'O') dfs(board, j,0);
            if (board[j][board[0].length-1] == 'O') dfs(board, j,board[0].length-1);
        }

        for(int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] ='O';
            }
        }
        return;
    }

    void dfs(char[][] board, int i, int j) {
        if (i<0 || j<0 || i>=board.length || j>= board[0].length || board[i][j] != 'O') return;
        board[i][j] = '#';
        dfs(board, i+1, j);
        dfs(board, i, j+1);
        dfs(board, i-1, j);
        dfs(board, i, j-1);
    }
    public static void main(String[] args) {
        SurroundedRegions s = new SurroundedRegions();
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};

        System.out.println(Arrays.deepToString(board));
        s.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
