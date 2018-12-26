package Medium;

import java.util.Arrays;

public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0) return board;
        int row = click[0], col = click[1], m = board.length, n=board[0].length;
        if (board[row][col]  == 'M') {
            board[row][col] = 'X';
        } else {
            int count = 0;
            for (int i=-1; i<2;i++) {
                for(int j=-1;j<2;j++) {
                    if (i==0 && j == 0) continue;
                    int r= row +  i, c = col +j;
                    if (r < 0 || r>=m || c < 0|| c>=n) continue;
                    if (board[r][c] == 'M' || board[r][c] == 'M') count++;
                }
            }
            if (count > 0) {
                board[row][col] =  (char) (count + '0');
            } else  {
                board[row][col] = 'B';
                for (int i=-1;i<2;i++) {
                    for (int j=-1;j<2;j++){
                        if (i==0 && j ==0) continue;;
                        int r= row +  i, c = col +j;
                        if (r < 0 || r>=m || c < 0|| c>=n) continue;
                        if (board[r][c] == 'E')  updateBoard(board, new int[] {r, c});
                    }
                }
            }
        }

        return board;
    }

    public static void main(String[] args) {
        Minesweeper  m  = new Minesweeper();
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        System.out.println(Arrays.deepToString(m.updateBoard(board, click)));
    }
}
