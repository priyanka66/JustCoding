package Medium;

public class Battleships {
    public int countBattleships(char[][] board) {
        if (board.length == 0) return 0;
        int count = 0;
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length ;j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(board, i, j);
                }
            }
        }

        return count;
    }

    void dfs(char[][]board, int i, int j) {
        if (i<0 || i>=board.length || j<0 ||j>=board[0].length || board[i][j] != 'X') return;
        board[i][j] = '.';
        dfs(board, i+1,j);
        dfs(board, i,j-1);
        dfs(board, i-1,j);
        dfs(board, i,j+1);

    }

    public int countBattleshipsV2 (char[][] board) {
        int count = 0;
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (board[i][j] == 'X' && (i==0 || board[i-1][j] == '.') && (j==0 || board[i][j-1] == '.')) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Battleships b = new Battleships();
        char[][] board = {
                {'.','.','.','X'},
                {'X','X','X','X'},
                {'.','.','.','X'}};

        System.out.println(b.countBattleships(board));
        System.out.println(b.countBattleshipsV2(board));

    }
}
