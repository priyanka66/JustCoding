package Medium;

import java.util.Arrays;

public class RangeSum2DImmutable {
    private int[][] sum = null;
    public RangeSum2DImmutable(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
        sum = new int[matrix.length+1][matrix[0].length+1];
        sum[1][1] = matrix[0][0];
        for (int i = 1;i< sum.length;i++) {
            sum[i][1] = sum[i-1][0] + matrix[i-1][0];
        }
        for (int j=1;j<sum[0].length;j++) {
            sum[1][j] = sum[0][j-1] + matrix[0][j-1];
        }
        System.out.println(Arrays.deepToString(sum));
        for (int i=2;i<sum.length;i++) {
            for (int j=2;j<sum[0].length;j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        System.out.println(Arrays.deepToString(sum));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        System.out.println(row2+1 + " " + (col2+1));
        System.out.println(row1 + " " + (col2+1));
        System.out.println(row2+1 + " " + col1);
        System.out.println(row1 + " " + col1);
        return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        RangeSum2DImmutable n = new RangeSum2DImmutable(matrix);
        System.out.println(n.sumRegion(2, 1, 4, 3));
    }
}
