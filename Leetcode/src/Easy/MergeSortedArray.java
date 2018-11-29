package Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArray {

    static void mergeSortedArrays(int[] nums1, int m , int[] nums2, int n){
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

        System.out.println(Arrays.toString(nums1));
    }
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[] num2 = {2,3,6};
        int[] num1 = {1,2,3,0,0,0};
//
        mergeSortedArrays(num1, m, num2, n);
//        System.out.println(Arrays.toString(result));

    }
}
