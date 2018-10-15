package Medium;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (dfs(board, words, i,j,0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int index) {
        if (index == words.length) return true;
        if(i<0 || j<0 || i>=board.length || j >=board[0].length) return false;
        if (board[i][j] != words[index] || board[i][j] == '-') return false;
        char c = board[i][j];
        board[i][j] = '-';
        boolean found = dfs(board, words, i+1,j, index+1) ||
                        dfs(board, words, i,j+1, index+1) ||
                        dfs(board, words, i-1,j, index+1) ||
                        dfs(board, words, i,j-1, index+1);
        board[i][j] = c;
        return found;
    }

    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};

        String word = "ABCB";
        System.out.println(w.exist(board, word));
    }
}
