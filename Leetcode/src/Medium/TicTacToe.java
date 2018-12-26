package Medium;


class TicTacToe {
    int[] rows ;
    int[] cols;
    int diagnonal, antiDiagonal;

    TicTacToe(int n) {
        rows  = new int[n];
        cols  = new int[n];
    }

    int move(int row, int col, int player) {
        int val =  player == 1 ? 1 : -1;
        rows[row] += val;
        cols[col] += val;
        if (row == col) diagnonal += val;
        if (col == cols.length-row-1) antiDiagonal+=val;

        int size = rows.length;
        if (Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs(diagnonal) == size ||
                Math.abs(antiDiagonal) == size)
            return player;

        else
            return 0;
    }

    public static void main(String[] args) {
        int n = 3;
        TicTacToe obj = new TicTacToe(n);
        System.out.println(obj.move(2,1,-1));
        System.out.println(obj.move(1,0,1));
        System.out.println(obj.move(2,0,-1));
        System.out.println(obj.move(1,1,1));
        System.out.println(obj.move(0,1,-1));
        System.out.println(obj.move(1,2,1));
        System.out.println(obj.move(2,2,-1));
    }
}

