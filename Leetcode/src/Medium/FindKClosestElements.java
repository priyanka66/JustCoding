package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result =  new ArrayList<>();
        if (arr.length == 0) return result;
        int start = 0, end=arr.length-1, mid=0;
        while (start<end) {
            mid = (start+end)/2;
            if (arr[mid] == x) {
                break;
            } else if (arr[mid] > x) end=mid;
            else start = mid +1;
        }
        if(mid < 0) mid = -(mid + 1);
        int i = mid-1, j=mid;
        while (k > 0) {
            if(i<0 || j < arr.length && Math.abs(arr[i]-x) > Math.abs(arr[j]-x)) {
                result.add(arr[j]);
                j++;
            }
            else {
                result.add(arr[i]);
                i--;
            }
            k--;
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        FindKClosestElements f = new FindKClosestElements();
        int[] arr = {1,2,3,4,5};
        int k = 4,x=3;
        System.out.println(f.findClosestElements(arr,k,x));
    }
}
