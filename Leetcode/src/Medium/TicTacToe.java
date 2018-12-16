package Medium;

import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args){
        char[][] playBoard = new char[3][3];
        char currentChar = 'X';
        boolean stillPlaying = true;
        int row = 0,col = 0;
        System.out.println(playBoard);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                playBoard[i][j] = '-';
            }
        }

        printBoard(playBoard);
        play(stillPlaying,row,col,playBoard,currentChar);
    }


    private static void play(boolean stillPlaying, int row, int col, char[][] playBoard, char currentChar) {
        stillPlaying = true;
        Scanner sc = new Scanner(System.in);
        while(stillPlaying){
            System.out.println("Player "+currentChar +" turn");
            System.out.println("Enter row");
            row = sc.nextInt();
            System.out.println("Enter column");
            col = sc.nextInt();
            playBoard[row][col] = currentChar;
            if(gameOver(playBoard,row,col)){
                stillPlaying = false;
                System.out.println("Game over! player "+currentChar +"wins");
            }
            if(currentChar == 'X'){
                currentChar = 'O';
            }else{
                currentChar = 'X';
            }
            printBoard(playBoard);
        }
    }


    private static boolean gameOver(char[][] playBoard, int row, int col) {
        if(playBoard[0][col] == playBoard[1][col] && playBoard[0][col] == playBoard[2][col])
            return true;
        if(playBoard[row][0] == playBoard[row][1] && playBoard[row][0] == playBoard[row][2])
            return true;
        if(playBoard[0][0] == playBoard[1][1] && playBoard[0][0] == playBoard[2][2] && playBoard[1][1]!='-')
            return true;
        if(playBoard[0][2] == playBoard[1][1] && playBoard[0][2] == playBoard[2][0] && playBoard[1][1]!='-')
            return true;

        return false;
    }


    private static void printBoard(char[][] temp) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(temp[i][j]);
            }
            System.out.print("\n");
        }
    }

}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */