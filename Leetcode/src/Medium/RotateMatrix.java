package Medium;

import java.util.Arrays;

public class RotateMatrix {

    private void rotate(int[][] matrix) {

        // Take a transpose
        System.out.println(Arrays.deepToString(matrix));
        for (int i=0;i<matrix.length;i++) {
            for (int j=i;j<matrix[0].length;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }

        }

        // Reverse elements of each row
        for (int i=0;i<matrix.length;i++) {
            int a=0,b=matrix.length-1;
            while (a<=b) {
                int temp = matrix[i][a];
                matrix[i][a] = matrix[i][b];
                matrix[i][b] = temp;
                a++;
                b--;
            }
        }

        System.out.println(Arrays.deepToString(matrix));


    }

    private void rotateAntiClock(int[][] matrix) {

        System.out.println("Anti Clock");
        System.out.println(Arrays.deepToString(matrix));
        // Reverse elements of each row
        for (int i=0;i<matrix.length;i++) {
            int a=0,b=matrix.length-1;
            while (a<=b) {
                int temp = matrix[i][a];
                matrix[i][a] = matrix[i][b];
                matrix[i][b] = temp;
                a++;
                b--;
            }
        }



        // Take a transpose
        for (int i=0;i<matrix.length;i++) {
            for (int j=i;j<matrix[0].length;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        System.out.println(Arrays.deepToString(matrix));

    }

    public static void main(String[] args) {
        RotateMatrix r = new RotateMatrix();
        int[][] matrix = {  {1,2,3},
                            {4,5,6},
                            {7,8,9}};
        int [][] matrix1 = matrix.clone();
        r.rotate(matrix);
        r.rotateAntiClock(matrix1);
    }

}
