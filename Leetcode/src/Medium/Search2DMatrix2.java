package Medium;

public class Search2DMatrix2 {

    private boolean searchMatrix(int[][] matrix, int target) {
        // dont start at matrix[0][0] coz u wont know what to increment. start at [0][j]
        if (matrix.length == 0) return false;
        int i=0, j=matrix[0].length-1;
        while (i<matrix.length && j>=0) {
            if (matrix[i][j] == target) return true;
            else {
                if (target < matrix[i][j]) j--;
                else i++;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        Search2DMatrix2 s = new Search2DMatrix2();
        int [][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        int target = 32;
        System.out.println(s.searchMatrix(matrix, target));
    }
}
