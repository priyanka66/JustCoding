package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class IntersectOfArrays {

    private int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hmap = new LinkedHashMap<>();
        int m = nums1.length;
        int n = nums2.length;
        int len = m<n ? m:n;
        int [] res = new int[len];
        for(int i=0;i< nums1.length;i++) {
           hmap.put(nums1[i], hmap.getOrDefault(nums1[i],0)+1);
        }
        int j =0;
        for(int i=0;i<nums2.length;i++) {
            if(hmap.containsKey(nums2[i]) && hmap.get(nums2[i]) > 0) {
                res[j++] = nums2[i];
                hmap.put(nums2[i],hmap.get(nums2[i])-1);
            }
        }
        int[] result = new int[j];
        for (int i=0;i<j;i++) {
            result[i] = res[i];
        }

        return result;
    }

    private int[] intersectV2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j= 0,index=0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums1[index++] = nums2[j];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else j++;
        }

        return Arrays.copyOf(nums1, index);
    }
    public static void main(String[] args) {
        IntersectOfArrays i = new IntersectOfArrays();
        int[] nums1 = {4,9,5};
        int[] nums2 = {4,9,8,4};
        System.out.println(Arrays.toString(i.intersect(nums1, nums2)));
        System.out.println(Arrays.toString(i.intersectV2(nums1, nums2)));
    }
}
