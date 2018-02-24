import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArray {

    static void mergeSortedArrays(int[] num1, int m , int[] num2, int n){
        if (m == 0) {
            num1 = num2;
            System.out.println(Arrays.toString(num1));
            return;
        }
        if (n == 0) {
            System.out.println(Arrays.toString(num1));
            return ;
        }
        int index = m+n-1, i=m-1,j=n-1;
        while (i>=0 &&  j>=0) {
            if (num1[i] > num2[j]) {
                num1[index--] = num1[i--];
            } else {
                num1[index--] = num2[j--];
            }
        }
        if (i==0) {
            while (j>0) {
                num1[index--] = num2[j--];
            }
        } else if (j == 0) {
            while (i>0) {
                num1[index--] = num1[i--];
            }
        }
        System.out.println(Arrays.toString(num1));
        return;

    }
    public static void main(String[] args) {
        int m = 0;
        int n = 1;
        int[] num3 = new int[]{0};
        int[] num2 = {1};
        int[] num1 = Arrays.copyOf(num3, 1);
        int[] num4 = num1;
//        System.out.println(Arrays.toString(num4));
//        num1 = num2;
//        System.out.println(Arrays.toString(num1));
//        System.out.println(Arrays.toString(num2));

        mergeSortedArrays(num1, m, num2, n);
//        System.out.println(Arrays.toString(result));

    }
}
