package Medium;

public class SetMatrixZeroes {

    private void setZeroes(int[][] matrix) {
        boolean fr=false, fc=false;
        for(int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0]= 0;
                    matrix[0][j] = 0;
                    if (i== 0) fr=true;
                    if (j== 0) fc = true;
                }
            }
        }


        for(int i=1;i<matrix.length;i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] ==0) {
                    matrix[i][j] =0;
                }
            }
        }

        if (fr) {
            for (int j=0;j<matrix[0].length;j++) matrix[0][j]=0;
        }

        if (fc) {
            for (int i=0;i<matrix.length;i++) matrix[i][0]=0;
        }


    }
    public static void main(String[] args) {
        SetMatrixZeroes z = new SetMatrixZeroes();

        int [][] matrix = {
                            {0},
                            {1}};

        for(int i=0;i<matrix.length;i++) {
            for(int j=0 ;j< matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        z.setZeroes(matrix);


        System.out.println("Result ");
        for(int i=0;i<matrix.length;i++) {
            for(int j=0 ;j< matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
