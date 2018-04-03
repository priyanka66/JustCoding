import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArray {

    static void mergeSortedArrays(int[] nums1, int m , int[] nums2, int n){
        int k = m;
        int l = n;
        while(m>0 && n>0){
            if(nums1[m-1]>nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }

        while(n>0){
            nums1[m+n-1] = nums2[n-1];
            n--;
        }

        for(int j=0;j<k+l;j++){
            System.out.println(nums1[j]);
        }

    }
    public static void main(String[] args) {
        int m = 1;
        int n = 1;
        int[] num3 = new int[]{1,0};
        int[] num2 = {2};
        int[] num1 = Arrays.copyOf(num3, 1);
        int[] num4 = num1;
//       
        mergeSortedArrays(num1, m, num2, n);
//        System.out.println(Arrays.toString(result));

    }
}
