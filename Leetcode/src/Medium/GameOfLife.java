package Medium;

public class GameOfLife {

    private void gameOfLife(int[][] board) {
        int m=board.length, n=board[0].length, count=0;
        for (int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                count = countOfNeighbors(i,j,m,n,board) +1;
                if (board[i][j] == 0) board[i][j] = -count;
                else board[i][j] = count;
            }
        }

        for(int i=0;i<board.length;i++) {
            for (int j=0;j<board[i].length;j++) {
                count = Math.abs(board[i][j]) -1;
                if (board[i][j]<0) {
                    if (count == 3) board[i][j] = 1;
                    else board[i][j]=0;
                } else {
                    if (count == 2 || count==3) board[i][j] = 1;
                    else board[i][j] = 0;
                }
            }
        }
    }

    private int countOfNeighbors(int i, int j, int m, int n, int[][] board) {
        int count = 0;

        // Horizontal neighbors
        if (i>0 && board[i-1][j] > 0) count++;
        if (i<m-1 && board[i+1][j] > 0) count++;

        //Vertical neighbors
        if (j>0 && board[i][j-1] > 0) count++;
        if (j<n-1 && board[i][j+1] >0) count++;

        //Diagonal neighbors

        if (i>0 && j>0 && board[i-1][j-1] >0) count++;
        if (i>0 && j < n-1 && board[i-1][j+1] > 0) count++;
        if (i<m-1 && j > 0 && board[i+1][j-1] > 0) count++;
        if (i<m-1 && j < n-1 && board[i+1][j+1] > 0) count++;

        return count;

    }
    public static void main(String[] args) {
        GameOfLife g = new GameOfLife();
        int [][] board = {{0,1,0},
                            {0,0,1},
                            {1,1,1},
                            {0,0,0}};
        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        g.gameOfLife(board);

        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
