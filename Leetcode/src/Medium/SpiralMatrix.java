package Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length ==0) return result;

        int top=0, left=0, m=matrix.length, n=matrix[0].length;
        int right = n-1, bottom=m-1;

        String dir = "TR";
        while (top<=bottom && left<=right) {
            // top to right
            if (dir == "TR") {
                for (int i = top; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
                // top to bottom
                dir = "TB";
            }
            else if (dir == "TB") {
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
                // Right to left
                dir = "RL";
            }
            else if (dir == "RL") {
                for (int i=right; i>=left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                // bottom to top
                dir="BT";
            }

            else if (dir == "BT") {
                for (int i=bottom;i>=top;i--) {
                    result.add(matrix[i][left]);

                }
                left++;
                dir = "TR";
            }

        }

        return result;
    }
    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        //[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        int[][] matrix = {{1,2,3,4},
                    {5,6,7,8},
                    { 9,10,11,12}};

        System.out.println(s.spiralOrder(matrix));
    }
}
