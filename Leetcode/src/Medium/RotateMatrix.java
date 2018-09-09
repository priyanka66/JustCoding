package Medium;

import java.util.Arrays;

public class RotateMatrix {

    private void rotate(int[][] matrix) {

        // Take a transpose
        System.out.println(matrix.length);
        for (int i=0;i<matrix.length;i++) {
            for (int j=i+1;j<matrix.length;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse elements of each row
        for (int i=0;i<matrix.length;i++){
            int a=0;
            int b=matrix.length-1;
            while (a<=(matrix.length/2) && b >= (matrix.length/2)) {
                int temp = matrix[i][a];
                matrix[i][a] = matrix[i][b];
                matrix[i][b] = temp;
                a++;
                b--;
            }
        }

        System.out.println(Arrays.deepToString(matrix));


    }
    public static void main(String[] args) {
        RotateMatrix r = new RotateMatrix();
        int[][] matrix = {  {1,2,3},
                            {4,5,6},
                            {7,8,9}};

        r.rotate(matrix);
    }

}
