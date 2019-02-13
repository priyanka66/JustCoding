package Easy;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A.length == 0) return false;
        if (A.length == 1) return true;
        boolean ascending = false, descending = false;
        for (int i=0;i<A.length-1;i++) {
            if (A[i] == A[i+1]) continue;
            if (A[i] > A[i+1]) ascending = true;
            if (A[i] < A[i+1]) descending = true;
            if (ascending && descending) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MonotonicArray m = new MonotonicArray();
        int[] A = {1,1,0};
        System.out.println(m.isMonotonic(A));
    }
}
