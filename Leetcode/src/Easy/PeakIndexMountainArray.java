package Easy;

public class PeakIndexMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        if (A.length == 0) return -1;
        int start=0,end=A.length-1,mid=0;
        while (start<=end) {
            mid = (start+end)/2;
            if (A[mid] < A[mid+1]) start=mid+1;
            else end=mid-1;
        }

        return start;
    }


    public static void main(String[] args) {
        int[] A = {0,1,0};
        PeakIndexMountainArray p = new PeakIndexMountainArray();
        System.out.println(p.peakIndexInMountainArray(A));
    }
}
