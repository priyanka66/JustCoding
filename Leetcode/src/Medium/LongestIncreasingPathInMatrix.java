package Medium;

import java.util.Map;

public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length ==  0) return 0;
        int result = 1;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i=0; i<m;i++) {
            for (int j=0;j<n;j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(matrix.length);
        for (int i=0; i<m;i++) {
            for (int j=0;j<n;j++) {
                if (dp[i][j] == -1)
                    dp[i][j] = longestIncreasingPath(i, j, matrix, dp);
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }

    int longestIncreasingPath(int i, int j, int[][] matrix, int[][] dp) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (i < matrix.length-1 && (matrix[i][j] < matrix[i+1][j]))
            return dp[i][j] = 1 +  longestIncreasingPath(i+1, j, matrix, dp);
        if (i > 0 && (matrix[i][j]  < matrix[i-1][j]))
            return dp[i][j] = 1 +  longestIncreasingPath(i-1, j, matrix, dp);
        if (j < matrix[0].length-1 && (matrix[i][j]  < matrix[i][j+1]))
            return dp[i][j] = 1 +  longestIncreasingPath(i, j+1, matrix, dp);
        if (j > 0 && (matrix[i][j]  < matrix[i][j-1]))
            return dp[i][j] = 1 +  longestIncreasingPath(i, j-1, matrix, dp);

        return dp[i][j] = 1;

    }

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        LongestIncreasingPathInMatrix m = new LongestIncreasingPathInMatrix();
        System.out.println(m.longestIncreasingPath(matrix));
    }
}
