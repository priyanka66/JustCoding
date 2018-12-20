package Medium;

import java.util.Arrays;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int row=n, col=n, count=1, x=0,y=-1;
        int[][] matrix = new int[n][n];
        while (count <= n*n) {
            for (int i=0;i<col;i++)
                matrix[x][++y] = count++;
            row--;
            for (int i=0;i<row;i++)
                matrix[++x][y] = count++;
            col--;
            for (int i=0;i<col;i++)
                matrix[x][--y] = count++;
            row--;
            for (int i=0;i<row;i++)
                matrix[--x][y] = count++;
            col--;
        }

        return matrix;
    }
    public static void main(String[] args) {
        SpiralMatrixII s = new SpiralMatrixII();
        int n =3;
        System.out.println(Arrays.deepToString(s.generateMatrix(n)));
    }
}
