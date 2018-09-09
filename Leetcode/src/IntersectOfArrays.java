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
            if (hmap.containsKey(nums1[i])) {
                hmap.put(nums1[i], hmap.get(nums1[i])+1);
            } else{
                hmap.put(nums1[i],1);
            }
        }
        int j =0;
        for(int i=0;i<nums2.length;i++) {
            if(hmap.containsKey(nums2[i]) && hmap.get(nums2[i]) >0 ) {
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
    public static void main(String[] args) {
        IntersectOfArrays i = new IntersectOfArrays();
        int[] nums1 = {1};
        int[] nums2 = {1,1};
        System.out.println(Arrays.toString(i.intersect(nums1, nums2)));
    }
}
